package sif3.au.naplan.consumer;

import sif.dd.au30.model.NAPEventStudentLinkCollectionType;
import sif.dd.au30.model.NAPEventStudentLinkType;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPEventStudentLinkConsumer extends NaplanSIFConsumer<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> {

    @Override
    protected SIFObjectInfo<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPEventStudentLink;
    }
}
