package sif3.au.naplan.provider.service;

import sif3.common.model.RequestMetadata;

public interface NaplanService<M> {

    public M retrieve(RequestMetadata metadata) throws Exception;

    public M retrieve(String schoolInfoRefId, RequestMetadata metadata) throws Exception;

}
