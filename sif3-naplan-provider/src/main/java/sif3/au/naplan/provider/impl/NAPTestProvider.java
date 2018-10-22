package sif3.au.naplan.provider.impl;

import sif.dd.au30.model.NAPTestCollectionType;
import sif.dd.au30.model.NAPTestType;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NAPTestService;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPTestProvider extends NaplanSIFProvider<NAPTestType, NAPTestCollectionType> {

    @Override
    protected SIFObjectInfo<NAPTestType, NAPTestCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPTest;
    }

    @Override
    protected NaplanService<NAPTestCollectionType> getService() {
        NAPTestService service = NaplanContext.getBean(NAPTestService.class);
        return service;
    }

}
