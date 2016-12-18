package com.ht.model;

import javax.persistence.*;

/**
 * Created by de on 2016/12/15.
 */
@Entity(name="TB_VEHICLE_TYPE")
public class VehicleType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="VEHICLE_TYPE_ID", nullable=false, length=11)
    private int vehicleTypeId;

    @Column(name="VEHICLE_TYPE_NAME", nullable=false, length=32)
    private String vehicleTypeName;

    @Column(name="PARENT_ID", nullable=true, length=11)
    private int parentId;

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
