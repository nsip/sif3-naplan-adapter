package sif3.au.naplan.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	private static String endpoint;
	private static String applicationKey;
	private static String password;

	static {
		Properties properties = new Properties();

		InputStream is = ClassLoader.getSystemResourceAsStream("test.properties");
		try {
			properties.load(is);
			endpoint = properties.getProperty("api.endpoint");
			applicationKey = properties.getProperty("api.applicationKey");
			password = properties.getProperty("api.password");
		} catch (IOException e) {
			// Handle exception here
		}

	}

	public static String getEndpoint() {
		return endpoint;
	}

	public static String getApplicationKey() {
		return applicationKey;
	}

	public static String getPassword() {
		return password;
	}

}
