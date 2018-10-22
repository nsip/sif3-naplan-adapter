package sif3.au.naplan.consumer;

import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.sif.SIFObjectInfo;

public class SchoolDataConsumer extends NaplanStringConsumer {

    @Override
    protected SIFObjectInfo<NaplanResponse, NaplanResponse> getSIFObjectInfo() {
        return SIFObjectInfo.SchoolData;
    }


    

}
