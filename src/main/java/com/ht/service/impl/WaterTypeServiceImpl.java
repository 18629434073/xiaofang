package com.ht.service.impl;

import com.ht.dao.IWaterTypeDao;
import com.ht.model.WaterType;
import com.ht.model.filters.Pagination;
import com.ht.service.IWaterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by de on 2016/12/15.
 */
@Service
public class WaterTypeServiceImpl implements IWaterTypeService {


    @Autowired(required = true)
    private IWaterTypeDao waterTypeDao;

    @Override
    public Pagination getWaterTypeList(Pagination page) {
        return waterTypeDao.getWaterTypeList(page);
    }

    @Override
    public void saveWaterType(WaterType waterType) {
        waterTypeDao.saveWaterType(waterType);
    }

    @Override
    public void delteWaterType(String ids) {
        for(String id:ids.split(",")){
            waterTypeDao.delteWaterType(id);
        }
    }

    @Override
    public WaterType getWaterType(String id) {
        return waterTypeDao.getWaterType(id);
    }

    @Override
    public void updateWaterType(WaterType waterType) {
        waterTypeDao.updateWaterType(waterType);
    }
}
