package com.ht.dao;

import com.ht.model.WaterType;
import com.ht.model.filters.Pagination;

/**
 * Created by de on 2016/12/15.
 */
public interface IWaterTypeDao {
    Pagination getWaterTypeList(Pagination page);

    void saveWaterType(WaterType waterType);

    void delteWaterType(String id);

    WaterType getWaterType(String id);

    void updateWaterType(WaterType waterType);
}
