package sif3.au.naplan.provider.impl;

import sif.dd.au30.model.NAPEventStudentLinkCollectionType;
import sif.dd.au30.model.NAPEventStudentLinkType;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.provider.service.NAPEventStudentLinkService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPEventStudentLinkProvider extends NaplanSIFProvider<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> {

    @Override
    protected SIFObjectInfo<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPEventStudentLink;
    }

    @Override
    protected NaplanService<NAPEventStudentLinkCollectionType> getService() {
        NAPEventStudentLinkService service = NaplanContext.getBean(NAPEventStudentLinkService.class);
        return service;
    }

}
