package sif3.au.naplan.provider.impl;

import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.provider.service.TestDataService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class TestDataProvider extends NaplanStringProvider {

    @Override
    protected SIFObjectInfo<NaplanResponse, NaplanResponse> getSIFObjectInfo() {
        return SIFObjectInfo.TestData;
    }

    @Override
    protected NaplanService<NaplanResponse> getService() {
        TestDataService service = NaplanContext.getBean(TestDataService.class);
        return service;
    }

}
