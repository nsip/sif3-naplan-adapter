package sif3.au.naplan.api.client;

import org.junit.Test;

import org.junit.Assert;
import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.api.util.TestProperties;

public class SchoolDataClientIT {

	@Test
	public void testSchoolDataWithRefId() throws Exception {
		NaplanClient client = NaplanClient.initialise(TestProperties.getEndpoint(), TestProperties.getApplicationKey(), TestProperties.getPassword());
		NaplanResponse response = client.schoolListClient().prepareRequest().executeGet();
		Assert.assertNotNull("response returned", response);
		Assert.assertNotNull("response body returned", response.getBody());
		Assert.assertTrue("response contains napresultsreporting tag",
				response.getBody().startsWith("<NAPResultsReporting"));
		Assert.assertTrue("response contains schoolinfo tag", response.getBody().indexOf("<SchoolInfo") >= 0);
		int firstRefIdIndex = response.getBody().indexOf("RefId");
		String firstRefId = response.getBody().substring(firstRefIdIndex+7, firstRefIdIndex+43); 
		
		NaplanResponse dataResponse = client.schoolDataClient(firstRefId).prepareRequest().executeGet();
		Assert.assertNotNull("response returned", dataResponse);
		Assert.assertNotNull("response body returned", dataResponse.getBody());
		Assert.assertTrue("response contains napresultsreporting tag",
				dataResponse.getBody().startsWith("<NAPResultsReporting"));
		Assert.assertTrue("response contains NAPStudentResponseSet tag", dataResponse.getBody().indexOf("<NAPStudentResponseSet") >= 0);
	}
}
