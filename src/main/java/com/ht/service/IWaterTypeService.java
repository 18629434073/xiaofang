package com.ht.service;

import com.ht.model.WaterType;
import com.ht.model.filters.Pagination;

/**
 * Created by de on 2016/12/15.
 */
public interface IWaterTypeService {
    Pagination getWaterTypeList(Pagination page);

    void saveWaterType(WaterType waterType);

    void delteWaterType(String ids);

    WaterType getWaterType(String id);

    void updateWaterType(WaterType waterType);
}
