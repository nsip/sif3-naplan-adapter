package sif3.au.naplan.api.client;

import static org.awaitility.Awaitility.await;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import sif3.au.naplan.api.model.NaplanRequest;

public class EndpointClientTest {

	@Test
	public void testConstructor() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";

		EndpointClient endpointClient = new EndpointClient(endpoint, applicationKey, password) {
			@Override
			public NaplanRequest prepareRequest() {
				// TODO Auto-generated method stub
				return null;
			}
		};

		Assert.assertNotNull(endpointClient.authentication);
	}

	@Test
	public void testAppendPath() {
		String left = "somePath";
		String right = "otherPath";
		String result = EndpointClient.appendPath(left, right);
		Assert.assertEquals("appended with seperator", left + "/" + right, result);
	}

	@Test
	public void testAppendPathWithSlash() {
		String left = "somePath/";
		String right = "otherPath";
		String result = EndpointClient.appendPath(left, right);
		Assert.assertEquals("appended without seperator", left + right, result);
	}

	@Test
	public void testAppendPathWithRightSlash() {
		String left = "somePath";
		String right = "/otherPath";
		String result = EndpointClient.appendPath(left, right);
		Assert.assertEquals("appended without seperator", left + right, result);
	}

	@Test
	public void testAppendPathWithBothSlashes() {
		String left = "somePath/";
		String right = "/otherPath";
		String result = EndpointClient.appendPath(left, right);
		Assert.assertEquals("appended without seperator", left + right.substring(1), result);
	}

	@Test
	public void testAppendPathWithBlankLeft() {
		String left = "";
		String right = "/otherPath";
		String result = EndpointClient.appendPath(left, right);
		Assert.assertNull("returned null", result);
	}

	@Test
	public void testAppendPathWithBlankRight() {
		String left = "somePath";
		String right = "";
		String result = EndpointClient.appendPath(left, right);
		Assert.assertEquals("left side only", left, result);
	}

	@Test
	public void testAppendPathWithBlankRightAndSlash() {
		String left = "somePath/";
		String right = "";
		String result = EndpointClient.appendPath(left, right);
		Assert.assertEquals("appended without seperator", left.substring(0, left.length() - 1), result);
	}

	@Test
	public void testAppendPathWithBlankBoth() {
		String left = "";
		String right = "";
		String result = EndpointClient.appendPath(left, right);
		Assert.assertNull("returned null", result);
	}

	@Test
	public void testAppendPathWithNullLeft() {
		String left = null;
		String right = "/otherPath";
		String result = EndpointClient.appendPath(left, right);
		Assert.assertNull("returned null", result);
	}

	@Test
	public void testAppendPathWithNullRight() {
		String left = "somePath";
		String right = null;
		String result = EndpointClient.appendPath(left, right);
		Assert.assertEquals("returned left", left, result);
	}

	@Test
	public void testAppendPathWithNullRightAndSlash() {
		String left = "somePath/";
		String right = null;
		String result = EndpointClient.appendPath(left, right);
		Assert.assertEquals("stripped seperator", left.substring(0, left.length() - 1), result);
	}

	@Test
	public void testAppendPathWithNullBoth() {
		String left = null;
		String right = null;
		String result = EndpointClient.appendPath(left, right);
		Assert.assertNull("result is null", result);
	}
	
	@Test
	public void authenticationRefreshed() throws InterruptedException {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		EndpointClient endpointClient = new EndpointClient(endpoint, applicationKey, password) {
			@Override
			public NaplanRequest prepareRequest() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		String authentication = endpointClient.authentication.getAuthentication();
		String timestamp = endpointClient.authentication.getTimestamp();
		await().atMost(2, TimeUnit.SECONDS).until(timestampIsDifferent(timestamp));
		endpointClient.prepareRequest("url");
		Assert.assertNotEquals("authentication changes", authentication, endpointClient.authentication.getAuthentication());
		Assert.assertNotEquals("timestamp changes", timestamp, endpointClient.authentication.getTimestamp());
	}
	
	@Test
	public void requestPrepared() {
		String endpoint = "endpoint";
		String applicationKey = "appplicationKey";
		String password = "password";
		String url = "url";
		EndpointClient endpointClient = new EndpointClient(endpoint, applicationKey, password) {
			@Override
			public NaplanRequest prepareRequest() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		NaplanRequest request = endpointClient.prepareRequest(url);
		Assert.assertNotNull("request created", request);
		Assert.assertEquals("url correct", url, request.buildUrl());
	}
	
	public static Callable<Boolean> timestampIsDifferent(String oldTimestamp) {
	      return new Callable<Boolean>() {
	            public Boolean call() throws Exception {
	                  return oldTimestamp != null && !oldTimestamp.equals(ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Z")).toString());
	            }
	      };
	}

}
