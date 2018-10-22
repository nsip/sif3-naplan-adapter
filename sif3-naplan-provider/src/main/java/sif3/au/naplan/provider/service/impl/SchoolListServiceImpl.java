package sif3.au.naplan.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sif3.au.naplan.api.client.NaplanClient;
import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.credentials.NaplanCredentials;
import sif3.au.naplan.provider.service.NaplanCredentialsService;
import sif3.au.naplan.provider.service.SchoolListService;
import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.model.RequestMetadata;

@Service
public class SchoolListServiceImpl extends BaseNaplanServiceImpl<NaplanResponse, NaplanResponse> implements SchoolListService {
    @Autowired
    NaplanClient naplanClient;

    @Autowired
    NaplanCredentialsService naplanCredentialsService;

    @Override
    protected SIFObjectInfo<NaplanResponse, NaplanResponse> getSIFObjectInfo() {
        return SIFObjectInfo.SchoolList;
    }

    @Override
    public NaplanResponse retrieve(RequestMetadata metadata) throws Exception {
        NaplanCredentials credentials = naplanCredentialsService.getCredentialsForRequest(metadata);
        return naplanClient.schoolListClient(credentials.getApplicationKey(), credentials.getPassword()).prepareRequest().executeGet();
    }

}
