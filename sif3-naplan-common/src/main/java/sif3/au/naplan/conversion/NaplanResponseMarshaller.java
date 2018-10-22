package sif3.au.naplan.conversion;

import org.apache.commons.lang3.StringUtils;

import sif3.au.naplan.api.model.NaplanResponse;
import sif3.common.exception.MarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;

public class NaplanResponseMarshaller extends NaplanMarshaller {

	@Override
	public String marshalToXML(Object obj) throws MarshalException, UnsupportedMediaTypeExcpetion {
		String result = null;
		if (obj != null && NaplanResponse.class.isAssignableFrom(obj.getClass())) {
			NaplanResponse naplanResponse = NaplanResponse.class.cast(obj);
			if (naplanResponse.isValid()) {
				result = naplanResponse.getBody();
			}
		}
		if (result == null) {
			throw new MarshalException("Unable to marshall object " + StringUtils.left("" + obj, 50) + "into XML.");
		}
		return result;
	}

}
