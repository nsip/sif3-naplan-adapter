package sif3.au.naplan.conversion;

import sif3.common.exception.UnmarshalException;
import sif3.common.utils.JAXBUtils;

public class DataModelUnmarshaller extends NaplanUnmarshaller {

    @Override
    public <T> T unmarshalXML(String payload, Class<T> clazz) throws UnmarshalException {
        T result = null;
        try {
            Object object = JAXBUtils.unmarshalFromXMLIntoObject(payload, clazz);
            if (clazz.isAssignableFrom(object.getClass())) {
                result = clazz.cast(object);
            }
        } catch (Exception ex) {
            throw new UnmarshalException(ex);
        }
        return result;
    }

}