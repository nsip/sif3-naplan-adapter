package sif3.au.naplan.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPTestCollectionType;
import sif.dd.au30.model.NAPTestType;
import sif3.au.naplan.api.client.NaplanClient;
import sif3.au.naplan.credentials.NaplanCredentials;
import sif3.au.naplan.provider.service.NAPTestService;
import sif3.au.naplan.provider.service.NaplanCredentialsService;
import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.model.RequestMetadata;

@Service
public class NAPTestServiceImpl extends BaseNaplanServiceImpl<NAPTestType, NAPTestCollectionType> implements NAPTestService {
    @Autowired
    NaplanClient naplanClient;

    @Autowired
    NaplanCredentialsService naplanCredentialsService;

    @Override
    protected SIFObjectInfo<NAPTestType, NAPTestCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPTest;
    }

    @Override
    public NAPTestCollectionType retrieve(RequestMetadata metadata) throws Exception {
        // You would look at caching this locally instead of going back to the api every time
        // and parsing the api response. Will be slow but proves the concept.
        NaplanCredentials credentials = naplanCredentialsService.getCredentialsForRequest(metadata);
        return extractResponse(naplanClient.testDataClient(credentials.getApplicationKey(), credentials.getPassword()).prepareRequest().executeGet());
    }

}
