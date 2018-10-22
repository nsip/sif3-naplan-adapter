package sif3.au.naplan.provider.impl;

import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.provider.service.SchoolListService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class SchoolListProvider extends NaplanStringProvider {

    @Override
    protected SIFObjectInfo<NaplanResponse, NaplanResponse> getSIFObjectInfo() {
        return SIFObjectInfo.SchoolList;
    }

    @Override
    protected NaplanService<NaplanResponse> getService() {
        SchoolListService service = NaplanContext.getBean(SchoolListService.class);
        return service;
    }

}
