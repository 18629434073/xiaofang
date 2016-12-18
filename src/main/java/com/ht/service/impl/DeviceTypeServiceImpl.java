package com.ht.service.impl;

import com.ht.dao.IDeviceTypeDao;
import com.ht.dao.IWaterTypeDao;
import com.ht.model.DeviceType;
import com.ht.model.WaterType;
import com.ht.model.filters.Pagination;
import com.ht.service.IDeviceTypeService;
import com.ht.service.IWaterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by de on 2016/12/15.
 */
@Service
public class DeviceTypeServiceImpl implements IDeviceTypeService {


    @Autowired(required = true)
    private IDeviceTypeDao deviceTypeDao;

    @Override
    public Pagination getDeviceTypeList(Pagination page) {
        return deviceTypeDao.getDeviceTypeList(page);
    }

    @Override
    public void saveDeviceType(DeviceType deviceType) {
        deviceTypeDao.saveDeviceType(deviceType);
    }

    @Override
    public void delteDeviceType(String ids) {
        for(String id:ids.split(",")){
            deviceTypeDao.delteDeviceType(id);
        }
    }

    @Override
    public DeviceType getDeviceType(String id) {
        return deviceTypeDao.getDeviceType(id);
    }

    @Override
    public void updateDeviceType(DeviceType deviceType) {
        deviceTypeDao.updateDeviceType(deviceType);
    }

}
