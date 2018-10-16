package sif3.au.naplan.api.client;

import org.apache.commons.lang3.StringUtils;

import sif3.au.naplan.api.model.Authentication;
import sif3.au.naplan.api.model.NaplanRequest;

public abstract class EndpointClient extends APIClient {

	protected Authentication authentication;

	public EndpointClient(String endpoint, String applicationKey, String password) {
		super(endpoint, applicationKey, password);
		this.authentication = new Authentication(applicationKey, password);
	}

	protected static String appendPath(String left, String right) {
		String result = StringUtils.trimToNull(StringUtils.strip(left, "/"));
		if (result != null) {
			String rightTrimmed = StringUtils.strip(right, "/");
			if (StringUtils.isNotBlank(rightTrimmed)) {
				result += "/" + rightTrimmed;
			}
		}
		return result;
	}

	public abstract NaplanRequest prepareRequest();

	public NaplanRequest prepareRequest(String url) {
		this.authentication.refresh();
		NaplanRequest request = new NaplanRequest(url, this.authentication.getAuthentication(),
				this.authentication.getTimestamp());
		return request;
	}
}
