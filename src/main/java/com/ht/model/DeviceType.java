package com.ht.model;

import javax.persistence.*;

/**
 * Created by de on 2016/12/15.
 */
@Entity(name="TB_DEVICE_TYPE")
public class DeviceType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="DEVICE_TYPE_ID", nullable=false, length=11)
    private int deviceTypeId;

    @Column(name="DEVICE_TYPE_NAME", nullable=false, length=32)
    private String deviceTypeName;

    @Column(name="PARENT_ID", nullable=true, length=11)
    private int parentId;

    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
