package sif3.au.naplan.api.client;

import sif3.au.naplan.api.model.NaplanRequest;

public class TestDataClient extends EndpointClient {

	protected static final String PATH = "TestData";

	public TestDataClient(String endpoint, String applicationKey, String password) {
		super(endpoint, applicationKey, password);
	}

	@Override
	public NaplanRequest prepareRequest() {
		return super.prepareRequest(appendPath(this.endpoint, PATH));
	}

}
