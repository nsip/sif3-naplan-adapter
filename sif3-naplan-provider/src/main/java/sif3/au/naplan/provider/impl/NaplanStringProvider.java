package sif3.au.naplan.provider.impl;

import sif3.au.naplan.api.model.NaplanResponse;
import sif3.common.exception.DataTooLargeException;
import sif3.common.exception.PersistenceException;
import sif3.common.exception.SIFException;
import sif3.common.exception.UnsupportedQueryException;
import sif3.common.model.PagingInfo;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryPredicate;
import sif3.common.model.RequestMetadata;
import sif3.common.model.ResponseParameters;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.ws.ErrorDetails;

public abstract class NaplanStringProvider extends NaplanProvider<NaplanResponse, NaplanResponse> {

    @Override
    public Object retrieveByServicePath(QueryCriteria queryCriteria, SIFZone zone, SIFContext context, PagingInfo pagingInfo, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws PersistenceException, UnsupportedQueryException, DataTooLargeException, SIFException {
        try {
            String schoolInfoRefId = null;
            for (QueryPredicate predicate : queryCriteria.getPredicates()) {
                if (predicate != null && "SchoolInfos".equals(predicate.getSubject())) {
                    schoolInfoRefId = predicate.getValue();
                }
            }
            return sanitiseResponse(getService().retrieve(schoolInfoRefId, pagingInfo, metadata));
        } catch (PersistenceException | SIFException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new SIFException(new ErrorDetails(500, ex.getMessage()));
        }
    }

    @Override
    public Object retrieve(SIFZone zone, SIFContext context, PagingInfo pagingInfo, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws PersistenceException, UnsupportedQueryException, DataTooLargeException, SIFException {
        try {
            return sanitiseResponse(getService().retrieve(pagingInfo, metadata));
        } catch (PersistenceException | SIFException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new SIFException(new ErrorDetails(500, ex.getMessage()));
        }
    }

    private NaplanResponse sanitiseResponse(NaplanResponse naplanResponse) throws SIFException {
        if (naplanResponse != null && naplanResponse.isValid()) {
            return naplanResponse;
        } else if (naplanResponse != null) {
            throw new SIFException(new ErrorDetails(500, naplanResponse.getBody()));
        }
        throw new SIFException(new ErrorDetails(500, "Unable to contact downstream system"));
    }
}
