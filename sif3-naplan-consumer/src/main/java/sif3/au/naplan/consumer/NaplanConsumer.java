package sif3.au.naplan.consumer;

import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.conversion.MarshalFactory;
import sif3.common.conversion.ModelObjectInfo;
import sif3.common.conversion.UnmarshalFactory;
import sif3.common.model.PagingInfo;
import sif3.common.model.QueryCriteria;
import sif3.common.model.delayed.DelayedResponseReceipt;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.ErrorDetails;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.model.MultiOperationStatusList;
import sif3.infra.rest.consumer.AbstractConsumer;

public abstract class NaplanConsumer<S, M> extends AbstractConsumer {
    protected abstract SIFObjectInfo<S, M> getSIFObjectInfo();

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

    public NaplanConsumer() {

    }

    @Override
    public void processDelayedCreateMany(MultiOperationStatusList<CreateOperationStatus> statusList, DelayedResponseReceipt receipt) {
        // Not Implemented
    }

    @Override
    public void processDelayedUpdateMany(MultiOperationStatusList<OperationStatus> statusList, DelayedResponseReceipt receipt) {
        // Not Implemented
    }

    @Override
    public void processDelayedDeleteMany(MultiOperationStatusList<OperationStatus> statusList, DelayedResponseReceipt receipt) {
        // Not Implemented
    }

    @Override
    public void processDelayedQuery(Object dataObject, PagingInfo pagingInfo, DelayedResponseReceipt receipt) {
        // Not Implemented
    }

    @Override
    public void processDelayedServicePath(Object dataObject, QueryCriteria queryCriteria, PagingInfo pagingInfo, DelayedResponseReceipt receipt) {
        // Not Implemented
    }

    @Override
    public void shutdown() {
        // Nothing to do.
    }

    @Override
    public void processDelayedError(ErrorDetails error, DelayedResponseReceipt receipt) {
        // Not Implemented
    }
}
