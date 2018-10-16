package sif3.au.naplan.api.client;

import org.junit.Assert;
import org.junit.Test;

public class NaplanClientTest {
	
	@Test
	public void testInitialiseWithEndpoint() {
		String endpoint = "endpoint";
		
		NaplanClient client = NaplanClient.initialise(endpoint);
		Assert.assertEquals("endpoint set", endpoint, client.endpoint);
		Assert.assertNull("no password", client.password);
		Assert.assertNull("no applicationKey", client.applicationKey);
	}
	
	@Test
	public void testInitialiseWithAuth() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		
		NaplanClient client = NaplanClient.initialise(endpoint, applicationKey, password);
		
		Assert.assertEquals("endpoint set", endpoint, client.endpoint);
		Assert.assertEquals("password set", password, client.password);
		Assert.assertEquals("applicationKey set", applicationKey, client.applicationKey);
	}
	
	@Test
	public void testDefaultTestDataClient() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		
		TestDataClient client = NaplanClient.initialise(endpoint, applicationKey, password).testDataClient();
		Assert.assertNotNull("client returned", client);
		Assert.assertEquals("endpoint set", endpoint, client.endpoint);
		Assert.assertEquals("password set", password, client.password);
		Assert.assertEquals("applicationKey set", applicationKey, client.applicationKey);
	}
	
	@Test
	public void testAuthenticationTestDataClient() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		
		TestDataClient client = NaplanClient.initialise(endpoint).testDataClient(applicationKey, password);
		Assert.assertNotNull("client returned", client);
		Assert.assertEquals("endpoint set", endpoint, client.endpoint);
		Assert.assertEquals("password set", password, client.password);
		Assert.assertEquals("applicationKey set", applicationKey, client.applicationKey);
	}
	
	@Test
	public void testDefaultSchoolListClient() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		
		SchoolListClient client = NaplanClient.initialise(endpoint, applicationKey, password).schoolListClient();
		Assert.assertNotNull("client returned", client);
		Assert.assertEquals("endpoint set", endpoint, client.endpoint);
		Assert.assertEquals("password set", password, client.password);
		Assert.assertEquals("applicationKey set", applicationKey, client.applicationKey);
	}
	
	@Test
	public void testAuthenticationSchoolListClient() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		
		SchoolListClient client = NaplanClient.initialise(endpoint).schoolListClient(applicationKey, password);
		Assert.assertNotNull("client returned", client);
		Assert.assertEquals("endpoint set", endpoint, client.endpoint);
		Assert.assertEquals("password set", password, client.password);
		Assert.assertEquals("applicationKey set", applicationKey, client.applicationKey);
	}
	
	@Test
	public void testDefaultSchoolDataClient() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		String refId = "refId";
		
		SchoolDataClient client = NaplanClient.initialise(endpoint, applicationKey, password).schoolDataClient(refId);
		Assert.assertNotNull("client returned", client);
		Assert.assertEquals("endpoint set", endpoint, client.endpoint);
		Assert.assertEquals("password set", password, client.password);
		Assert.assertEquals("applicationKey set", applicationKey, client.applicationKey);
		Assert.assertEquals("refId set", refId, client.refId);
	}

	@Test
	public void testAuthenticationSchoolDataClient() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		String refId = "refId";
		
		SchoolDataClient client = NaplanClient.initialise(endpoint).schoolDataClient(applicationKey, password, refId);
		Assert.assertNotNull("client returned", client);
		Assert.assertEquals("endpoint set", endpoint, client.endpoint);
		Assert.assertEquals("password set", password, client.password);
		Assert.assertEquals("applicationKey set", applicationKey, client.applicationKey);
		Assert.assertEquals("refId set", refId, client.refId);
	}

}
