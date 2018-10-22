package sif3.au.naplan.api.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class NaplanResponse implements Serializable {
	private static final long serialVersionUID = 1554507597284846228L;

	private String body;

	public NaplanResponse() {

	}

	public NaplanResponse(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public boolean isValid() {
		return StringUtils.isNotBlank(body) && body.startsWith("<NAPResultsReporting"); 
	}
}
