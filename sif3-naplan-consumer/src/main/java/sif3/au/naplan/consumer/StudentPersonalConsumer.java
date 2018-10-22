package sif3.au.naplan.consumer;

import sif.dd.au30.model.StudentPersonalCollectionType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.au.naplan.sif.SIFObjectInfo;

public class StudentPersonalConsumer extends NaplanSIFConsumer<StudentPersonalType, StudentPersonalCollectionType> {

    @Override
    protected SIFObjectInfo<StudentPersonalType, StudentPersonalCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.StudentPersonal;
    }
}
