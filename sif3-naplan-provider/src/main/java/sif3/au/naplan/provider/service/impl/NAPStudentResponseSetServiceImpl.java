package sif3.au.naplan.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPStudentResponseSetCollectionType;
import sif.dd.au30.model.NAPStudentResponseSetType;
import sif3.au.naplan.api.client.NaplanClient;
import sif3.au.naplan.credentials.NaplanCredentials;
import sif3.au.naplan.provider.service.NAPStudentResponseSetService;
import sif3.au.naplan.provider.service.NaplanCredentialsService;
import sif3.au.naplan.sif.SIFObjectInfo;
import sif3.common.model.PagingInfo;
import sif3.common.model.RequestMetadata;

@Service
public class NAPStudentResponseSetServiceImpl extends BaseNaplanServiceImpl<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> implements NAPStudentResponseSetService {
    @Autowired
    NaplanClient naplanClient;

    @Autowired
    NaplanCredentialsService naplanCredentialsService;

    @Override
    protected SIFObjectInfo<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPStudentResponseSet;
    }

    @Override
    public NAPStudentResponseSetCollectionType retrieve(String schoolInfoRefId, PagingInfo pagingInfo, RequestMetadata metadata) throws Exception {
        // You would look at caching this locally instead of going back to the api every time
        // and parsing the api response. Will be slow but proves the concept.
        // Paging ignored for now
        NaplanCredentials credentials = naplanCredentialsService.getCredentialsForRequest(metadata);
        return extractResponse(naplanClient.schoolDataClient(credentials.getApplicationKey(), credentials.getPassword(), schoolInfoRefId).prepareRequest().executeGet());
    }
}
