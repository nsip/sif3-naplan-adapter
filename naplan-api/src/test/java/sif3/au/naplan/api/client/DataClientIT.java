package sif3.au.naplan.api.client;

import org.junit.Assert;
import org.junit.Test;

import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.api.util.TestProperties;

public class DataClientIT {
	
	@Test
	public void testTestData() throws Exception {
		NaplanResponse response = NaplanClient
				.initialise(TestProperties.getEndpoint(), TestProperties.getApplicationKey(), TestProperties.getPassword())
				.testDataClient().prepareRequest().executeGet();
		Assert.assertNotNull("response returned", response);
		Assert.assertNotNull("response body returned", response.getBody());
		Assert.assertTrue("response contains napresultsreporting tag", response.getBody().startsWith("<NAPResultsReporting"));
		Assert.assertTrue("response contains NAPCodeFrame tag", response.getBody().indexOf("<NAPCodeFrame") >= 0);
	}
}
