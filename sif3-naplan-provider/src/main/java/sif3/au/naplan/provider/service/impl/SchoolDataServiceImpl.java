package sif3.au.naplan.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sif3.au.naplan.api.client.NaplanClient;
import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.credentials.NaplanCredentials;
import sif3.au.naplan.provider.service.NaplanCredentialsService;
import sif3.au.naplan.provider.service.SchoolDataService;
import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.model.PagingInfo;
import sif3.common.model.RequestMetadata;

@Service
public class SchoolDataServiceImpl extends BaseNaplanServiceImpl<NaplanResponse, NaplanResponse> implements SchoolDataService {
    @Autowired
    NaplanClient naplanClient;

    @Autowired
    NaplanCredentialsService naplanCredentialsService;

    @Override
    protected SIFObjectInfo<NaplanResponse, NaplanResponse> getSIFObjectInfo() {
        return SIFObjectInfo.SchoolData;
    }

    @Override
    public NaplanResponse retrieve(String schoolInfoRefId, PagingInfo pagingInfo, RequestMetadata metadata) throws Exception {
        // Paging ignored for now
        NaplanCredentials credentials = naplanCredentialsService.getCredentialsForRequest(metadata);
        return naplanClient.schoolDataClient(credentials.getApplicationKey(), credentials.getPassword(), schoolInfoRefId).prepareRequest().executeGet();
    }

}
