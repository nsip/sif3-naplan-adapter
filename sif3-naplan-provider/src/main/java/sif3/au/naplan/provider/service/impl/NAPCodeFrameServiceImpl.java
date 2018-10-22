package sif3.au.naplan.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPCodeFrameCollectionType;
import sif.dd.au30.model.NAPCodeFrameType;
import sif3.au.naplan.api.client.NaplanClient;
import sif3.au.naplan.credentials.NaplanCredentials;
import sif3.au.naplan.provider.service.NAPCodeFrameService;
import sif3.au.naplan.provider.service.NaplanCredentialsService;
import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.model.RequestMetadata;

@Service
public class NAPCodeFrameServiceImpl extends BaseNaplanServiceImpl<NAPCodeFrameType, NAPCodeFrameCollectionType> implements NAPCodeFrameService {
    @Autowired
    NaplanClient naplanClient;

    @Autowired
    NaplanCredentialsService naplanCredentialsService;

    @Override
    protected SIFObjectInfo<NAPCodeFrameType, NAPCodeFrameCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPCodeFrame;
    }

    @Override
    public NAPCodeFrameCollectionType retrieve(RequestMetadata metadata) throws Exception {
        // You would look at caching this locally instead of going back to the api every time
        // and parsing the api response. Will be slow but proves the concept.
        NaplanCredentials credentials = naplanCredentialsService.getCredentialsForRequest(metadata);
        return extractResponse(naplanClient.testDataClient(credentials.getApplicationKey(), credentials.getPassword()).prepareRequest().executeGet());
    }

}
