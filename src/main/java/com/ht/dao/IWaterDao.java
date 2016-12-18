package com.ht.dao;

import com.ht.model.Water;
import com.ht.model.filters.Pagination;

import java.util.List;

/**
 * Created by UPC on 2016/12/13.
 */
public interface IWaterDao {
    List<Water> getWaterList(Water water, Pagination page);

    void saveWaterlocation(Water water);

    void updateWaterlocation(Water water);

    Water getWater(String id);

    void deleteWaterlocation(String ids);
}
