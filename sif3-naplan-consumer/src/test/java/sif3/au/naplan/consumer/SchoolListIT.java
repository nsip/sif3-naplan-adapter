package sif3.au.naplan.consumer;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sif3.au.naplan.api.model.NaplanResponse;
import sif3.common.header.HeaderValues.RequestType;
import sif3.common.model.PagingInfo;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class SchoolListIT {
    SchoolListConsumer consumer;

    @Before
    public void setup() {
        ConsumerLoader.initialise("NaplanConsumer");
        consumer = new SchoolListConsumer();
    }

    @Test
    public void testConsumer() {
        try {
            List<Response> responses = consumer.retrieve(new PagingInfo(1, 1), null, RequestType.IMMEDIATE);
            Assert.assertNotNull("Response exists", responses);
            Assert.assertEquals("One response", 1, responses.size());
            Assert.assertNotNull("Response exists", responses.get(0));
            Assert.assertNotNull("Response body exists", responses.get(0).getDataObject());
            Assert.assertTrue("Response body correct type", NaplanResponse.class.isAssignableFrom(responses.get(0).getDataObject().getClass()));
            Assert.assertTrue("Response body contains NAPResultsReporting", NaplanResponse.class.cast(responses.get(0).getDataObject()).getBody().contains("<NAPResultsReporting "));
            Assert.assertTrue("Response body contains SchoolInfo", NaplanResponse.class.cast(responses.get(0).getDataObject()).getBody().contains("<SchoolInfo "));
        } catch (Exception ex) {
            Assert.assertNull("No exceptions", ex);
        }

    }
}
