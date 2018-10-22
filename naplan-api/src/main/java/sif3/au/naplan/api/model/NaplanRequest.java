package sif3.au.naplan.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NaplanRequest {
	private static final Logger LOG = LoggerFactory.getLogger(NaplanRequest.class);

	private final String url;
	private final String authentication;
	private final String timestamp;

	private OkHttpClient httpClient;

	public NaplanRequest(String url, String authentication, String timestamp) {
		this.url = url;
		this.authentication = authentication;
		this.timestamp = timestamp;
	}

	public NaplanResponse executeGet() throws Exception {
		if (httpClient == null) {
			httpClient = new OkHttpClient();
		}

		String url = buildUrl();

		LOG.info("\nAuthorization: " + authentication + "\ntimestamp: " + timestamp + "\n\n");
		
		Request request = new Request.Builder()
				.url(url)
				.addHeader("Authorization", authentication)
				.addHeader("timestamp", timestamp).build();

		LOG.trace("Request URL: {}", url);

		Response response = httpClient.newCall(request).execute();
		String responseBody = response.body().string();

		LOG.trace("Response body: {}", responseBody);

		return new NaplanResponse(responseBody);
	}

	public String buildUrl() {
		return this.url;
	}

}
