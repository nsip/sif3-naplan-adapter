package sif3.au.naplan.consumer;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sif.dd.au30.model.NAPStudentResponseSetCollectionType;
import sif3.au.naplan.consumer.constants.RefIds;
import sif3.common.header.HeaderValues.RequestType;
import sif3.common.model.PagingInfo;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPStudentResponseSetIT {
    NAPStudentResponseSetConsumer consumer;

    @Before
    public void setup() {
        ConsumerLoader.initialise("NaplanConsumer");
        consumer = new NAPStudentResponseSetConsumer();
    }

    @Test
    public void testConsumer() {
        try {
            QueryCriteria queryCriteria = new QueryCriteria();
            QueryPredicate queryPredicate = new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, RefIds.SCHOOLINFO_REF_ID);
            queryCriteria.addPredicate(queryPredicate);
            List<Response> responses = consumer.retrieveByServicePath(queryCriteria, new PagingInfo(1, 1), null, RequestType.IMMEDIATE);
            Assert.assertNotNull("Response exists", responses);
            Assert.assertEquals("One response", 1, responses.size());
            Assert.assertNotNull("Response exists", responses.get(0));
            Assert.assertNotNull("Response body exists", responses.get(0).getDataObject());
            Assert.assertTrue("Response body correct type", NAPStudentResponseSetCollectionType.class.isAssignableFrom(responses.get(0).getDataObject().getClass()));
            Assert.assertTrue("Response body contains NAPEventStudentLinks", NAPStudentResponseSetCollectionType.class.cast(responses.get(0).getDataObject()).getNAPStudentResponseSet().size() > 0);
        } catch (Exception ex) {
            Assert.assertNull("No exceptions", ex);
        }

    }
}
