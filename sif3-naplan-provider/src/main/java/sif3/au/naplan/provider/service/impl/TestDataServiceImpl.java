package sif3.au.naplan.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sif3.au.naplan.api.client.NaplanClient;
import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.credentials.NaplanCredentials;
import sif3.au.naplan.provider.service.NaplanCredentialsService;
import sif3.au.naplan.provider.service.TestDataService;
import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.model.PagingInfo;
import sif3.common.model.RequestMetadata;

@Service
public class TestDataServiceImpl extends BaseNaplanServiceImpl<NaplanResponse, NaplanResponse> implements TestDataService {
    @Autowired
    NaplanClient naplanClient;

    @Autowired
    NaplanCredentialsService naplanCredentialsService;

    @Override
    protected SIFObjectInfo<NaplanResponse, NaplanResponse> getSIFObjectInfo() {
        return SIFObjectInfo.TestData;
    }

    @Override
    public NaplanResponse retrieve(PagingInfo pagingInfo, RequestMetadata metadata) throws Exception {
        // Paging ignored for now
        NaplanCredentials credentials = naplanCredentialsService.getCredentialsForRequest(metadata);
        return naplanClient.testDataClient(credentials.getApplicationKey(), credentials.getPassword()).prepareRequest().executeGet();
    }

}
