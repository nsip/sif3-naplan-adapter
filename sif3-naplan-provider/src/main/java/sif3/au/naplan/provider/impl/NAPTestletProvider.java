package sif3.au.naplan.provider.impl;

import sif.dd.au30.model.NAPTestletCollectionType;
import sif.dd.au30.model.NAPTestletType;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NAPTestletService;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPTestletProvider extends NaplanSIFProvider<NAPTestletType, NAPTestletCollectionType> {

    @Override
    protected SIFObjectInfo<NAPTestletType, NAPTestletCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPTestlet;
    }

    @Override
    protected NaplanService<NAPTestletCollectionType> getService() {
        NAPTestletService service = NaplanContext.getBean(NAPTestletService.class);
        return service;
    }

}
