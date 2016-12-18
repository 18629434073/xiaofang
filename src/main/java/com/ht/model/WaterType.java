package com.ht.model;

import javax.persistence.*;

/**
 * Created by de on 2016/12/15.
 */
@Entity(name="TB_WATER_TYPE")
public class WaterType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="WATER_TYPE_ID", nullable=false, length=11)
    private int waterTypeId;

    @Column(name="WATER_TYPE_NAME", nullable=false, length=32)
    private String waterTypeName;

    @Column(name="PARENT_ID", nullable=true, length=11)
    private int parentId;

    public int getWaterTypeId() {
        return waterTypeId;
    }

    public void setWaterTypeId(int waterTypeId) {
        this.waterTypeId = waterTypeId;
    }

    public String getWaterTypeName() {
        return waterTypeName;
    }

    public void setWaterTypeName(String waterTypeName) {
        this.waterTypeName = waterTypeName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
