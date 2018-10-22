package sif3.au.naplan.consumer;

import sif.dd.au30.model.NAPTestCollectionType;
import sif.dd.au30.model.NAPTestType;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPTestConsumer extends NaplanSIFConsumer<NAPTestType, NAPTestCollectionType> {

    @Override
    protected SIFObjectInfo<NAPTestType, NAPTestCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPTest;
    }
}
