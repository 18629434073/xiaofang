package com.ht.dao;

import com.ht.model.DeviceType;
import com.ht.model.WaterType;
import com.ht.model.filters.Pagination;

/**
 * Created by de on 2016/12/15.
 */
public interface IDeviceTypeDao {
    Pagination getDeviceTypeList(Pagination page);

    void saveDeviceType(DeviceType deviceType);

    void delteDeviceType(String id);

    DeviceType getDeviceType(String id);

    void updateDeviceType(DeviceType deviceType);
}
