package sif3.au.naplan.consumer;

import sif.dd.au30.model.SchoolInfoCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.au.naplan.sif.SIFObjectInfo;

public class SchoolInfoConsumer extends NaplanSIFConsumer<SchoolInfoType, SchoolInfoCollectionType> {

    @Override
    protected SIFObjectInfo<SchoolInfoType, SchoolInfoCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.SchoolInfo;
    }
}
