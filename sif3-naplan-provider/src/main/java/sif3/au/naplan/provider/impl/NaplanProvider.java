package sif3.au.naplan.provider.impl;

import java.util.List;

import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.conversion.MarshalFactory;
import sif3.common.conversion.ModelObjectInfo;
import sif3.common.conversion.UnmarshalFactory;
import sif3.common.exception.DataTooLargeException;
import sif3.common.exception.PersistenceException;
import sif3.common.exception.SIFException;
import sif3.common.exception.UnsupportedQueryException;
import sif3.common.header.HeaderProperties;
import sif3.common.interfaces.QueryProvider;
import sif3.common.model.PagingInfo;
import sif3.common.model.RequestMetadata;
import sif3.common.model.ResponseParameters;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.infra.rest.provider.BaseProvider;

public abstract class NaplanProvider<S, M> extends BaseProvider implements QueryProvider {
    protected abstract SIFObjectInfo<S, M> getSIFObjectInfo();
    protected abstract NaplanService<M> getService();

    @Override
    public MarshalFactory getMarshaller() {
        return getSIFObjectInfo().marshaller;
    }

    @Override
    public UnmarshalFactory getUnmarshaller() {
        return getSIFObjectInfo().unmarshaller;
    }

    @Override
    public ModelObjectInfo getSingleObjectClassInfo() {
        return getSIFObjectInfo().singleObjectInfo;
    }

    @Override
    public ModelObjectInfo getMultiObjectClassInfo() {
        return getSIFObjectInfo().multiObjectInfo;
    }

    @Override
    public Object retrievByPrimaryKey(String resourceID, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException, SIFException {
        throw new UnsupportedQueryException("Query by RefId not supported by Naplan API");
    }

    @Override
    public Object createSingle(Object data, boolean useAdvisory, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException, SIFException {
        // Should never be able to get here.
        throw new UnsupportedQueryException("Create operations not supported by Naplan API");
    }

    @Override
    public boolean updateSingle(Object data, String resourceID, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException, SIFException {
        // Should never be able to get here.
        throw new UnsupportedQueryException("Update operations not supported by Naplan API");
    }

    @Override
    public boolean deleteSingle(String resourceID, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException, SIFException {
        // Should never be able to get here.
        throw new UnsupportedQueryException("Delete operations not supported by Naplan API");
    }

    @Override
    public List<CreateOperationStatus> createMany(Object data, boolean useAdvisory, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException, SIFException {
        // Should never be able to get here.
        throw new UnsupportedQueryException("Create operations not supported by Naplan API");
    }

    @Override
    public List<OperationStatus> updateMany(Object data, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException, SIFException {
        // Should never be able to get here.
        throw new UnsupportedQueryException("Update operations not supported by Naplan API");
    }

    @Override
    public List<OperationStatus> deleteMany(List<String> resourceIDs, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException, SIFException {
        // Should never be able to get here.
        throw new UnsupportedQueryException("Delete operations not supported by Naplan API");
    }

    @Override
    public void shutdown() {
    }

    @Override
    public HeaderProperties getCustomServiceInfo(SIFZone zone, SIFContext context, PagingInfo pagingInfo, RequestMetadata metadata)
            throws PersistenceException, UnsupportedQueryException, DataTooLargeException, SIFException {
        // This should probably be implemented properly.
        return new HeaderProperties();
    }

    @Override
    public Object retrieveByQBE(Object exampleObject, SIFZone zone, SIFContext context, PagingInfo pagingInfo, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws PersistenceException, UnsupportedQueryException, DataTooLargeException, SIFException {
        throw new UnsupportedQueryException("Query by example not supported by Naplan API");
    }

}
