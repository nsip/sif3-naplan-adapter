package sif3.au.naplan.api.client;

public abstract class APIClient {
	protected String applicationKey;
	protected String password;
	protected String endpoint;

	public APIClient(String endpoint, String applicationKey, String password) {
		this.endpoint = endpoint;
		this.applicationKey = applicationKey;
		this.password = password;
	}
}
