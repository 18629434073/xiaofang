package com.ht.service.impl;

import com.ht.dao.IUserDao;
import com.ht.dao.IWaterDao;
import com.ht.model.Water;
import com.ht.model.filters.Pagination;
import com.ht.service.WaterLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by UPC on 2016/12/13.
 */
@Service
public class WaterLocationServiceImpl implements WaterLocationService {

    @Autowired(required = true)
    private IWaterDao waterDao;
    @Override
    public List<Water> getWaterList(Water water, Pagination page) {
        return waterDao.getWaterList(water,page);
    }

    @Override
    public void saveWaterlocation(Water water) {
        waterDao. saveWaterlocation(water);
    }

    @Override
    public void updateWaterlocation(Water water) {
        waterDao.updateWaterlocation(water);
    }

    @Override
    public Water getWater(String id) {
        return waterDao.getWater(id);
    }

    @Override
    public void deleteWaterlocation(String ids) {
        waterDao.deleteWaterlocation(ids);
    }
}
