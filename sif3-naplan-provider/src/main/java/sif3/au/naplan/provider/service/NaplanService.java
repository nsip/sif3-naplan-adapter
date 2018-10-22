package sif3.au.naplan.provider.service;

import sif3.common.model.PagingInfo;
import sif3.common.model.RequestMetadata;

public interface NaplanService<M> {

    public M retrieve(PagingInfo pagingInfo, RequestMetadata metadata) throws Exception;

    public M retrieve(String schoolInfoRefId, PagingInfo pagingInfo, RequestMetadata metadata) throws Exception;

}
