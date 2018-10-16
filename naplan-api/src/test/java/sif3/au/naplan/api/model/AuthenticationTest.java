package sif3.au.naplan.api.model;

import static org.awaitility.Awaitility.await;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import sif3.au.naplan.api.client.EndpointClientTest;

public class AuthenticationTest {

	private static final ZoneId Z = ZoneId.of("Z");

	@Test
	public void testConstructorWithTimestamp() {
		String applicationKey = "appplicationKey";
		String password = "password";
		ZonedDateTime timestamp = ZonedDateTime.now().minusDays(1);

		Authentication authentication = new Authentication(applicationKey, password, timestamp);
		Assert.assertNotNull("timestamp set", authentication.getTimestamp());
		Assert.assertEquals("timestamp correct", timestamp.withZoneSameInstant(Z).toString(),
				authentication.getTimestamp());
		Assert.assertNotNull("authentication set", authentication.getAuthentication());
	}

	@Test
	public void testConstructorWithoutTimestamp() {
		String applicationKey = "appplicationKey";
		String password = "password";

		Authentication authentication = new Authentication(applicationKey, password);
		Assert.assertNotNull("timestamp set", authentication.getTimestamp());
		Assert.assertNotNull("authentication set", authentication.getAuthentication());
	}

	@Test
	public void testRefresh() {
		String applicationKey = "appplicationKey";
		String password = "password";

		Authentication authentication = new Authentication(applicationKey, password);
		Assert.assertNotNull("timestamp set", authentication.getTimestamp());
		Assert.assertNotNull("authentication set", authentication.getAuthentication());
		String timestamp = authentication.getTimestamp();
		String auth = authentication.getAuthentication();
		await().atMost(2, TimeUnit.SECONDS).until(EndpointClientTest.timestampIsDifferent(timestamp));
		authentication.refresh();
		Assert.assertNotEquals("timestamp set", timestamp, authentication.getTimestamp());
		Assert.assertNotEquals("authentication set", auth, authentication.getAuthentication());
	}
	
	@Test
	public void testRefreshWithTimestamp() {
		String applicationKey = "appplicationKey";
		String password = "password";
		ZonedDateTime time = ZonedDateTime.now().minusDays(1);

		Authentication authentication = new Authentication(applicationKey, password);
		Assert.assertNotNull("timestamp set", authentication.getTimestamp());
		Assert.assertNotNull("authentication set", authentication.getAuthentication());
		String timestamp = authentication.getTimestamp();
		String auth = authentication.getAuthentication();
		authentication.refresh(time);
		Assert.assertNotEquals("timestamp set", timestamp, authentication.getTimestamp());
		Assert.assertNotEquals("authentication set", auth, authentication.getAuthentication());
		Assert.assertEquals("timestamp set", time.withZoneSameInstant(Z).toString(), authentication.getTimestamp());
	}
}
