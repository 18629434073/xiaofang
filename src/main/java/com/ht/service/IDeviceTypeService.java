package com.ht.service;

import com.ht.model.DeviceType;
import com.ht.model.filters.Pagination;

/**
 * Created by de on 2016/12/15.
 */
public interface IDeviceTypeService {
    Pagination getDeviceTypeList(Pagination page);

    void saveDeviceType(DeviceType deviceType);

    void delteDeviceType(String ids);

    DeviceType getDeviceType(String id);

    void updateDeviceType(DeviceType deviceType);
}
