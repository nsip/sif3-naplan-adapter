package sif3.au.naplan.provider.impl;

import sif.dd.au30.model.NAPTestScoreSummaryCollectionType;
import sif.dd.au30.model.NAPTestScoreSummaryType;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.provider.service.NAPTestScoreSummaryService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPTestScoreSummaryProvider extends NaplanSIFProvider<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType> {

    @Override
    protected SIFObjectInfo<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPTestScoreSummary;
    }

    @Override
    protected NaplanService<NAPTestScoreSummaryCollectionType> getService() {
        NAPTestScoreSummaryService service = NaplanContext.getBean(NAPTestScoreSummaryService.class);
        return service;
    }

}
