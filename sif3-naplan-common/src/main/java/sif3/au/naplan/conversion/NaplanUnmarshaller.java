package sif3.au.naplan.conversion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import sif3.common.conversion.UnmarshalFactory;
import sif3.common.exception.UnmarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;

public abstract class NaplanUnmarshaller implements UnmarshalFactory {

	protected static final HashSet<MediaType> supportedMediaTypes = new HashSet<MediaType>(
			Arrays.asList(MediaType.APPLICATION_XML_TYPE, MediaType.TEXT_XML_TYPE));
	protected static final MediaType defaultMediaType = MediaType.APPLICATION_XML_TYPE;

	public Set<MediaType> getSupportedMediaTypes() {
		return supportedMediaTypes;
	}

	public boolean isSupported(MediaType mediaType) {
		if (mediaType != null) {
			Set<MediaType> mediaTypes = getSupportedMediaTypes();
			for (Iterator<MediaType> iter = mediaTypes.iterator(); iter.hasNext();) {
				if (mediaType.isCompatible(iter.next())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public MediaType getDefault() {
		return defaultMediaType;
	}

	@Override
	public Object unmarshalFromXML(String payload, Class<?> clazz)
			throws UnmarshalException, UnsupportedMediaTypeExcpetion {
		return unmarshalXML(payload, clazz);
	}

	@Override
	public Object unmarshalFromJSON(String payload, Class<?> clazz)
			throws UnmarshalException, UnsupportedMediaTypeExcpetion {
		throw new UnsupportedMediaTypeExcpetion(
				"Unsupported media type: Cannot unmarshal the given json to this object type.");
	}

	@Override
	public Object unmarshal(String payload, Class<?> clazz, MediaType mediaType)
			throws UnmarshalException, UnsupportedMediaTypeExcpetion {
		if (mediaType != null) {
			if (MediaType.APPLICATION_XML_TYPE.isCompatible(mediaType)
					|| MediaType.TEXT_XML_TYPE.isCompatible(mediaType)) {
				return unmarshalFromXML(payload, clazz);
			} else if (MediaType.APPLICATION_JSON_TYPE.isCompatible(mediaType)) {
				return unmarshalFromJSON(payload, clazz);
			}
		}
		throw new UnsupportedMediaTypeExcpetion(
				"Unsupported media type: " + mediaType + ". Cannot unmarshal the given input from this media type.");
	}

	public abstract <T> T unmarshalXML(String payload, Class<T> clazz) throws UnmarshalException;

}
