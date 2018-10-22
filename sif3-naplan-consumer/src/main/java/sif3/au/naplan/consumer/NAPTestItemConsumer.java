package sif3.au.naplan.consumer;

import sif.dd.au30.model.NAPTestItemCollectionType;
import sif.dd.au30.model.NAPTestItemType;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPTestItemConsumer extends NaplanSIFConsumer<NAPTestItemType, NAPTestItemCollectionType> {

    @Override
    protected SIFObjectInfo<NAPTestItemType, NAPTestItemCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPTestItem;
    }
}
