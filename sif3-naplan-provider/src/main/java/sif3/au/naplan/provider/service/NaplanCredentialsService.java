package sif3.au.naplan.provider.service;

import sif3.au.naplan.credentials.NaplanCredentials;
import sif3.common.model.RequestMetadata;

public interface NaplanCredentialsService {
    public NaplanCredentials getCredentialsForRequest(RequestMetadata metadata);
}
