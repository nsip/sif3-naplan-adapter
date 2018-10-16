package sif3.au.naplan.api.client;

import org.junit.Test;

import org.junit.Assert;
import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.api.util.TestProperties;

public class SchoolListClientIT {

	@Test
	public void testSchoolList() throws Exception {
		NaplanResponse response = NaplanClient
				.initialise(TestProperties.getEndpoint(), TestProperties.getApplicationKey(), TestProperties.getPassword())
				.schoolListClient().prepareRequest().executeGet();
		Assert.assertNotNull("response returned", response);
		Assert.assertNotNull("response body returned", response.getBody());
		Assert.assertTrue("response contains napresultsreporting tag", response.getBody().startsWith("<NAPResultsReporting"));
		Assert.assertTrue("response contains schoolinfo tag", response.getBody().indexOf("<SchoolInfo") >= 0);
	}
}
