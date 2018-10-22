package sif3.au.naplan.conversion;

import sif3.au.naplan.api.model.NaplanResponse;

public class NaplanResponseUnmarshaller extends NaplanUnmarshaller {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T unmarshalXML(String payload, Class<T> clazz) {
		// Should never be called in this direction.
		if (NaplanResponse.class.isAssignableFrom(clazz)) {
			return (T) new NaplanResponse(payload);
		}
		return null;
	}

}
