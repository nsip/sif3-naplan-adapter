package sif3.au.naplan.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.SchoolInfoCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.au.naplan.api.client.NaplanClient;
import sif3.au.naplan.credentials.NaplanCredentials;
import sif3.au.naplan.provider.service.SchoolInfoService;
import sif3.au.naplan.provider.service.NaplanCredentialsService;
import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.model.RequestMetadata;

@Service
public class SchoolInfoServiceImpl extends BaseNaplanServiceImpl<SchoolInfoType, SchoolInfoCollectionType> implements SchoolInfoService {
    @Autowired
    NaplanClient naplanClient;

    @Autowired
    NaplanCredentialsService naplanCredentialsService;

    @Override
    protected SIFObjectInfo<SchoolInfoType, SchoolInfoCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.SchoolInfo;
    }

    @Override
    public SchoolInfoCollectionType retrieve(RequestMetadata metadata) throws Exception {
        // You would look at caching this locally instead of going back to the api every time
        // and parsing the api response. Will be slow but proves the concept.
        NaplanCredentials credentials = naplanCredentialsService.getCredentialsForRequest(metadata);
        return extractResponse(naplanClient.schoolListClient(credentials.getApplicationKey(), credentials.getPassword()).prepareRequest().executeGet());
    }

}
