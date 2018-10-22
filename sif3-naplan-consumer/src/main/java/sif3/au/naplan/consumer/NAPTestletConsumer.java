package sif3.au.naplan.consumer;

import sif.dd.au30.model.NAPTestletCollectionType;
import sif.dd.au30.model.NAPTestletType;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPTestletConsumer extends NaplanSIFConsumer<NAPTestletType, NAPTestletCollectionType> {

    @Override
    protected SIFObjectInfo<NAPTestletType, NAPTestletCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPTestlet;
    }
}
