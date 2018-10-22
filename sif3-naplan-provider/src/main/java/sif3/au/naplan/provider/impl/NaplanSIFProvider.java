package sif3.au.naplan.provider.impl;

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

public abstract class NaplanSIFProvider<S, M> extends NaplanProvider<S, M> {

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
            return getService().retrieve(schoolInfoRefId, metadata);
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
            return getService().retrieve(metadata);
        } catch (PersistenceException | SIFException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new SIFException(new ErrorDetails(500, ex.getMessage()));
        }
    }

}
