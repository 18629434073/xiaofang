package com.ht.service.impl;

import com.ht.dao.IDeviceTypeDao;
import com.ht.dao.IVehicleTypeDao;
import com.ht.model.DeviceType;
import com.ht.model.VehicleType;
import com.ht.model.filters.Pagination;
import com.ht.service.IDeviceTypeService;
import com.ht.service.IVehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by de on 2016/12/15.
 */
@Service
public class VehicleTypeServiceImpl implements IVehicleTypeService {


    @Autowired(required = true)
    private IVehicleTypeDao vehicleTypeDao;

    @Override
    public Pagination getVehicleTypeList(Pagination page) {
        return vehicleTypeDao.getVehicleTypeList(page);
    }

    @Override
    public void saveVehicleType(VehicleType vehicleType) {
        vehicleTypeDao.saveVehicleType(vehicleType);
    }

    @Override
    public void delteVehicleType(String ids) {
        for(String id:ids.split(",")){
            vehicleTypeDao.delteVehicleType(id);
        }
    }

    @Override
    public VehicleType getVehicleType(String id) {
        return vehicleTypeDao.getVehicleType(id);
    }

    @Override
    public void updateVehicleType(VehicleType vehicleType) {
        vehicleTypeDao.updateVehicleType(vehicleType);
    }

}
