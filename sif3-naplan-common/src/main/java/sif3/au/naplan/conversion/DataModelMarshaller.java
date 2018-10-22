package sif3.au.naplan.conversion;

import sif3.au.naplan.sif.ObjectFactoryHelper;
import sif3.common.exception.MarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.common.utils.JAXBUtils;

public class DataModelMarshaller extends NaplanMarshaller {

    @Override
    public String marshalToXML(Object obj) throws MarshalException, UnsupportedMediaTypeExcpetion {
        try {
            return JAXBUtils.marshalToXML(ObjectFactoryHelper.createObject(obj, obj.getClass()));
        } catch (Exception ex) {
            throw new MarshalException("Unable to marshall object into XML", ex);
        }
    }

}
