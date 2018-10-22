package sif3.au.naplan.consumer;

import sif.dd.au30.model.NAPTestScoreSummaryCollectionType;
import sif.dd.au30.model.NAPTestScoreSummaryType;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPTestScoreSummary extends NaplanSIFConsumer<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType> {

    @Override
    protected SIFObjectInfo<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPTestScoreSummary;
    }
}
