package sif3.au.naplan.provider.impl;

import sif.dd.au30.model.NAPCodeFrameCollectionType;
import sif.dd.au30.model.NAPCodeFrameType;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NAPCodeFrameService;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPCodeFrameProvider extends NaplanSIFProvider<NAPCodeFrameType, NAPCodeFrameCollectionType> {

    @Override
    protected SIFObjectInfo<NAPCodeFrameType, NAPCodeFrameCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPCodeFrame;
    }

    @Override
    protected NaplanService<NAPCodeFrameCollectionType> getService() {
        NAPCodeFrameService service = NaplanContext.getBean(NAPCodeFrameService.class);
        return service;
    }

}
