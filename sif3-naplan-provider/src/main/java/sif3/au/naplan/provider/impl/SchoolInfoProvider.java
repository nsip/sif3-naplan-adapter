package sif3.au.naplan.provider.impl;

import sif.dd.au30.model.SchoolInfoCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.provider.service.SchoolInfoService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class SchoolInfoProvider extends NaplanSIFProvider<SchoolInfoType, SchoolInfoCollectionType> {

    @Override
    protected SIFObjectInfo<SchoolInfoType, SchoolInfoCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.SchoolInfo;
    }

    @Override
    protected NaplanService<SchoolInfoCollectionType> getService() {
        SchoolInfoService service = NaplanContext.getBean(SchoolInfoService.class);
        return service;
    }

}
