package sif3.au.naplan.api.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import sif3.common.utils.AuthenticationUtils;

public class Authentication {
	private String applicationKey;
	private String password;
	private String authentication;
	private String timestamp;
	private static final ZoneId Z = ZoneId.of("Z");

	public Authentication(String applicationKey, String password, ZonedDateTime timestamp) {
		this.applicationKey = applicationKey;
		this.password = password;
		this.refresh(timestamp);
	}

	public Authentication(String applicationKey, String password) {
		this(applicationKey, password, ZonedDateTime.now());
	}

	public Authentication refresh() {
		return refresh(ZonedDateTime.now());
	}

	public Authentication refresh(ZonedDateTime dateTime) {
		this.timestamp = dateTime.withZoneSameInstant(Z).toString();
		this.authentication = AuthenticationUtils.getSIFHMACSHA256AuthToken(applicationKey, password, timestamp);
		return this;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getAuthentication() {
		return authentication;
	}

}
