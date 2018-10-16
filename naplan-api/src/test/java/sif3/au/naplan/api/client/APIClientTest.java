package sif3.au.naplan.api.client;

import org.junit.Test;

import org.junit.Assert;

public class APIClientTest {

	@Test
	public void testConstructor() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		
		APIClient apiClient = new APIClient(endpoint, applicationKey, password) {
		};
		
		Assert.assertEquals("endpoint set", endpoint, apiClient.endpoint);
		Assert.assertEquals("applicationKey set", applicationKey, apiClient.applicationKey);
		Assert.assertEquals("password set", password, apiClient.password);
	}
}
