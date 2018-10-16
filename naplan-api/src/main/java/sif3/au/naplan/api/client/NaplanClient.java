package sif3.au.naplan.api.client;

public class NaplanClient extends APIClient {
	private static String baseEndpoint;

	private NaplanClient() {
		super(baseEndpoint, null, null);
	}

	private NaplanClient(String applicationKey, String password) {
		super(baseEndpoint, applicationKey, password);
	}

	public static NaplanClient initialise(String endpoint) {
		NaplanClient.baseEndpoint = endpoint;
		return new NaplanClient();
	}

	public static NaplanClient initialise(String endpoint, String applicationKey, String password) {
		NaplanClient.baseEndpoint = endpoint;
		return new NaplanClient(applicationKey, password);
	}

	public TestDataClient testDataClient() {
		return new TestDataClient(NaplanClient.baseEndpoint, this.applicationKey, this.password);
	}

	public TestDataClient testDataClient(String applicationKey, String password) {
		return new TestDataClient(NaplanClient.baseEndpoint, applicationKey, password);
	}

	public SchoolListClient schoolListClient() {
		return new SchoolListClient(NaplanClient.baseEndpoint, this.applicationKey, this.password);
	}

	public SchoolListClient schoolListClient(String applicationKey, String password) {
		return new SchoolListClient(NaplanClient.baseEndpoint, applicationKey, password);
	}

	public SchoolDataClient schoolDataClient(String refId) {
		return new SchoolDataClient(NaplanClient.baseEndpoint, this.applicationKey, this.password, refId);
	}

	public SchoolDataClient schoolDataClient(String applicationKey, String password, String refId) {
		return new SchoolDataClient(NaplanClient.baseEndpoint, applicationKey, password, refId);
	}

}
