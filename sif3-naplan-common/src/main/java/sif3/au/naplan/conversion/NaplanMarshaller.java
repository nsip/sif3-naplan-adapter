package sif3.au.naplan.conversion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import sif3.common.conversion.MarshalFactory;
import sif3.common.exception.MarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;

public abstract class NaplanMarshaller implements MarshalFactory {

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
	public String marshal(Object obj, MediaType mediaType) throws MarshalException, UnsupportedMediaTypeExcpetion {
		if (mediaType != null) {
			if (MediaType.APPLICATION_XML_TYPE.isCompatible(mediaType)
					|| MediaType.TEXT_XML_TYPE.isCompatible(mediaType)) {
				return marshalToXML(obj);
			} else if (MediaType.APPLICATION_JSON_TYPE.isCompatible(mediaType)) {
				return marshalToJSON(obj);
			}
		}
		// If we get here then we deal with an unknown media type
		throw new UnsupportedMediaTypeExcpetion(
				"Unsupported media type: " + mediaType + ". Cannot marshal the given input to this media type.");
	}

	public abstract String marshalToXML(Object obj) throws MarshalException, UnsupportedMediaTypeExcpetion;

	@Override
	public String marshalToJSON(Object obj) throws MarshalException, UnsupportedMediaTypeExcpetion {
		throw new UnsupportedMediaTypeExcpetion("Unsupported media type: Cannot marshal the given object to json.");
	}

}
