package sif3.au.naplan.api.client;

import org.junit.Assert;
import org.junit.Test;

import sif3.au.naplan.api.model.NaplanRequest;

public class SchoolListClientTest {

	@Test
	public void testConstructor() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		
		SchoolListClient client = new SchoolListClient(endpoint, applicationKey, password);
		Assert.assertEquals("endpoint set", endpoint, client.endpoint);
		Assert.assertEquals("password set", password, client.password);
		Assert.assertEquals("applicationKey set", applicationKey, client.applicationKey);
	}

	@Test
	public void testPrepareRequest() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		
		SchoolListClient client = new SchoolListClient(endpoint, applicationKey, password);
		NaplanRequest request = client.prepareRequest();
		Assert.assertNotNull("request returned", request);
		Assert.assertTrue("endpoint correct", request.buildUrl().startsWith(endpoint));
		Assert.assertTrue("path correct", request.buildUrl().endsWith(SchoolListClient.PATH));
	}


}
