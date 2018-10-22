package sif3.au.naplan.provider.impl;

import sif.dd.au30.model.NAPTestItemCollectionType;
import sif.dd.au30.model.NAPTestItemType;
import sif3.au.naplan.provider.config.NaplanContext;
import sif3.au.naplan.provider.service.NAPTestItemService;
import sif3.au.naplan.provider.service.NaplanService;
import sif3.au.naplan.sif.SIFObjectInfo;

public class NAPTestItemProvider extends NaplanSIFProvider<NAPTestItemType, NAPTestItemCollectionType> {

    @Override
    protected SIFObjectInfo<NAPTestItemType, NAPTestItemCollectionType> getSIFObjectInfo() {
        return SIFObjectInfo.NAPTestItem;
    }

    @Override
    protected NaplanService<NAPTestItemCollectionType> getService() {
        NAPTestItemService service = NaplanContext.getBean(NAPTestItemService.class);
        return service;
    }

}
