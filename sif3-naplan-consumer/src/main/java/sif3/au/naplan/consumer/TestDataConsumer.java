package sif3.au.naplan.consumer;

import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.sif.SIFObjectInfo;

public class TestDataConsumer extends NaplanStringConsumer {

    @Override
    protected SIFObjectInfo<NaplanResponse, NaplanResponse> getSIFObjectInfo() {
        return SIFObjectInfo.TestData;
    }

}
