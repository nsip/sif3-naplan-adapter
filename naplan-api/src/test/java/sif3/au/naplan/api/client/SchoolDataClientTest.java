package sif3.au.naplan.api.client;

import org.junit.Assert;
import org.junit.Test;

import sif3.au.naplan.api.model.NaplanRequest;

public class SchoolDataClientTest {

	@Test
	public void testConstructor() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		String refId = "refId";
		
		SchoolDataClient client = new SchoolDataClient(endpoint, applicationKey, password, refId);
		Assert.assertEquals("endpoint set", endpoint, client.endpoint);
		Assert.assertEquals("password set", password, client.password);
		Assert.assertEquals("applicationKey set", applicationKey, client.applicationKey);
		Assert.assertEquals("refId set", refId, client.refId);
	}

	@Test
	public void testPrepareRequest() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		String refId = "refId";
		
		SchoolDataClient client = new SchoolDataClient(endpoint, applicationKey, password, refId);
		NaplanRequest request = client.prepareRequest();
		Assert.assertNotNull("request returned", request);
		Assert.assertTrue("endpoint correct", request.buildUrl().startsWith(endpoint));
		Assert.assertTrue("path correct", request.buildUrl().indexOf(SchoolDataClient.PATH) > 0);
		Assert.assertTrue("refId correct", request.buildUrl().endsWith(refId));
	}

	@Test
	public void testPrepareSchoolRequest() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		String refId = "refId";
		
		SchoolDataClient client = new SchoolDataClient(endpoint, applicationKey, password, null);
		NaplanRequest request = client.prepareSchoolRequest(refId);
		Assert.assertNotNull("request returned", request);
		Assert.assertTrue("endpoint correct", request.buildUrl().startsWith(endpoint));
		Assert.assertTrue("path correct", request.buildUrl().indexOf(SchoolDataClient.PATH) > 0);
		Assert.assertTrue("refId correct", request.buildUrl().endsWith(refId));
	}

}
