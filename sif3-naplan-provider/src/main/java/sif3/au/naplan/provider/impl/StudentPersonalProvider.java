package sif3.au.naplan.provider.impl;

import sif.dd.au30.model.StudentPersonalCollectionType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.provider.service.StudentPersonalService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class StudentPersonalProvider extends NaplanSIFProvider<StudentPersonalType, StudentPersonalCollectionType> {

    @Override
    protected SIFObjectInfo<StudentPersonalType, StudentPersonalCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.StudentPersonal;
    }

    @Override
    protected NaplanService<StudentPersonalCollectionType> getService() {
        StudentPersonalService service = NaplanContext.getBean(StudentPersonalService.class);
        return service;
    }

}
