package sif3.au.naplan.provider.impl;

import sif.dd.au30.model.NAPStudentResponseSetCollectionType;
import sif.dd.au30.model.NAPStudentResponseSetType;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.provider.service.NAPStudentResponseSetService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPStudentResponseSetProvider extends NaplanSIFProvider<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> {

    @Override
    protected SIFObjectInfo<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPStudentResponseSet;
    }

    @Override
    protected NaplanService<NAPStudentResponseSetCollectionType> getService() {
        NAPStudentResponseSetService service = NaplanContext.getBean(NAPStudentResponseSetService.class);
        return service;
    }

}
