package com.ht.service;

import com.ht.model.VehicleType;
import com.ht.model.filters.Pagination;

/**
 * Created by de on 2016/12/15.
 */
public interface IVehicleTypeService {
    Pagination getVehicleTypeList(Pagination page);

    void saveVehicleType(VehicleType vehicleType);

    void delteVehicleType(String ids);

    VehicleType getVehicleType(String id);

    void updateVehicleType(VehicleType vehicleType);
}
