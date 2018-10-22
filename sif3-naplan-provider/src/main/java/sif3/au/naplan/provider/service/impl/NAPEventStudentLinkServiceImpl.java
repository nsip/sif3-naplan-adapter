package sif3.au.naplan.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPEventStudentLinkCollectionType;
import sif.dd.au30.model.NAPEventStudentLinkType;
import sif3.au.naplan.api.client.NaplanClient;
import sif3.au.naplan.credentials.NaplanCredentials;
import sif3.au.naplan.provider.service.NAPEventStudentLinkService;
import sif3.au.naplan.provider.service.NaplanCredentialsService;
import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.model.RequestMetadata;

@Service
public class NAPEventStudentLinkServiceImpl extends BaseNaplanServiceImpl<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> implements NAPEventStudentLinkService {
    @Autowired
    NaplanClient naplanClient;

    @Autowired
    NaplanCredentialsService naplanCredentialsService;

    @Override
    protected SIFObjectInfo<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPEventStudentLink;
    }

    @Override
    public NAPEventStudentLinkCollectionType retrieve(String schoolInfoRefId, RequestMetadata metadata) throws Exception {
        // You would look at caching this locally instead of going back to the api every time
        // and parsing the api response. Will be slow but proves the concept.
        NaplanCredentials credentials = naplanCredentialsService.getCredentialsForRequest(metadata);
        return extractResponse(naplanClient.schoolDataClient(credentials.getApplicationKey(), credentials.getPassword(), schoolInfoRefId).prepareRequest().executeGet());
    }

}
