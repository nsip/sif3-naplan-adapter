package sif3.au.naplan.consumer;

import sif.dd.au30.model.NAPCodeFrameCollectionType;
import sif.dd.au30.model.NAPCodeFrameType;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPCodeFrameConsumer extends NaplanSIFConsumer<NAPCodeFrameType, NAPCodeFrameCollectionType> {

    @Override
    protected SIFObjectInfo<NAPCodeFrameType, NAPCodeFrameCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPCodeFrame;
    }
}
