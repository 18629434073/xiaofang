package com.ht.dao;

import com.ht.model.VehicleType;
import com.ht.model.filters.Pagination;

/**
 * Created by de on 2016/12/15.
 */
public interface IVehicleTypeDao {
    Pagination getVehicleTypeList(Pagination page);

    void saveVehicleType(VehicleType vehicleType);

    void delteVehicleType(String id);

    VehicleType getVehicleType(String id);

    void updateVehicleType(VehicleType vehicleType);
}
