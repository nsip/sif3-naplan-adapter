package sif3.au.naplan.provider.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.sif.CollectionHelper;
import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.exception.SIFException;
import sif3.common.exception.UnmarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.common.exception.UnsupportedQueryException;
import sif3.common.model.RequestMetadata;
import sif3.common.ws.ErrorDetails;

public abstract class BaseNaplanServiceImpl<S, M> implements NaplanService<M> {

    protected abstract SIFObjectInfo<S, M> getSIFObjectInfo();

    @Override
    public M retrieve(RequestMetadata metadata) throws Exception {
        throw new UnsupportedQueryException("Query without service path not supported by Naplan API.");
    }

    @Override
    public M retrieve(String schoolInfoRefId, RequestMetadata metadata) throws Exception {
        throw new UnsupportedQueryException("Query by service path not supported by Naplan API.");
    }

    protected M extractResponse(NaplanResponse naplanResponse) throws SIFException, UnmarshalException, UnsupportedMediaTypeExcpetion {
        if (naplanResponse != null && naplanResponse.isValid()) {
            try {
                M result = getSIFObjectInfo().collectionClass.newInstance();
                List<S> objects = gatherObjects(naplanResponse.getBody());
                CollectionHelper.getCollection(result, getSIFObjectInfo().collectionClass, getSIFObjectInfo().objectClass).addAll(objects);
                return result;
            } catch (Exception ex) {
                throw new SIFException(new ErrorDetails(500, ex.getMessage()), ex);
            }
        } else if (naplanResponse != null) {
            throw new SIFException(new ErrorDetails(500, naplanResponse.getBody()));
        }
        throw new SIFException(new ErrorDetails(500, "Unable to contact downstream system"));
    }

    private List<S> gatherObjects(String payload) throws UnmarshalException {
        List<S> result = new ArrayList<>();
        int openIndex = getOpenIndex(payload, getSIFObjectInfo().objectName, 0);
        while (openIndex >= 0) {
            int closeIndex = getCloseIndex(payload, getSIFObjectInfo().objectName, openIndex);
            if (closeIndex >= 0) {
                S object = getSIFObjectInfo().typedUnmarshaller.unmarshalXML(StringUtils.substring(payload, openIndex, closeIndex), getSIFObjectInfo().objectClass);
                result.add(object);
            }
            openIndex = getOpenIndex(payload, getSIFObjectInfo().objectName, closeIndex);
        }
        return result;
    }

    private int getOpenIndex(String input, String objectName, int fromIndex) {
        int result = input.indexOf("<" + objectName + " ", fromIndex);
        if (result < 0) {
            result = input.indexOf("<" + objectName + ">", fromIndex);
        }
        return result;
    }

    private int getCloseIndex(String input, String objectName, int fromIndex) {
        int index = input.indexOf("</" + objectName + ">", fromIndex);
        if (index >= 0) {
            index += objectName.length() + 3;
        }
        return index;
    }

}
