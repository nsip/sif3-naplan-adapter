package sif3.au.naplan.consumer;

import sif.dd.au30.model.NAPStudentResponseSetCollectionType;
import sif.dd.au30.model.NAPStudentResponseSetType;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPStudentResponseSetConsumer extends NaplanSIFConsumer<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> {

    @Override
    protected SIFObjectInfo<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPStudentResponseSet;
    }
}
