package sif3.au.naplan.api.client;

import au.com.systemic.framework.utils.StringUtils;
import sif3.au.naplan.api.model.NaplanRequest;

public class SchoolDataClient extends EndpointClient {

	protected static final String PATH = "SchoolData";
	protected String refId;

	public SchoolDataClient(String baseEndpoint, String applicationKey, String password, String refId) {
		super(baseEndpoint, applicationKey, password);
		this.refId = refId;
	}

	@Override
	public NaplanRequest prepareRequest() {
		if (StringUtils.notEmpty(refId)) {
			return super.prepareRequest(appendPath(this.endpoint, PATH + "/" + refId));
		} else {
			return super.prepareRequest(appendPath(this.endpoint, PATH));
		}
	}

	public NaplanRequest prepareSchoolRequest(String refId) {
		this.refId = refId;
		return prepareRequest();
	}

}
