package sif3.au.naplan.provider.impl;

import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.provider.service.SchoolDataService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class SchoolDataProvider extends NaplanStringProvider {

    @Override
    protected SIFObjectInfo<NaplanResponse, NaplanResponse> getSIFObjectInfo() {
        return SIFObjectInfo.SchoolData;
    }

    @Override
    protected NaplanService<NaplanResponse> getService() {
        SchoolDataService service = NaplanContext.getBean(SchoolDataService.class);
        return service;
    }

}
