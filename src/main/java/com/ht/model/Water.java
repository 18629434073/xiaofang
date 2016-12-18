package com.ht.model;

import javax.persistence.*;

/**
 * Created by UPC on 2016/12/13.
 */
@Entity(name = "TB_WATER")
public class Water {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WATER_ID", nullable = false, length = 11)
    private int waterId;

    @Column(name = "WATER_TYPE_ID", nullable = false, length = 11)
    private int waterTypeId;

    @Column(name = "WATER_NAME", length = 32)
    private String waterName;

    @Column(name = "WATER_ADDRESS",length = 255)
    private String waterAddress;

    @Column(name = "LONGTITUDE", length = 11)
    private float longtitude;

    @Column(name = "LATITUDE",length = 11)
    private float latitude;

    @Column(name = "STATUS",length = 2)
    private int status;

    @Column(name = "TROOP_ID",nullable = false,length = 11)
    private int troopId;

    @Column(name = "MAINTAI_NAME",length =32)
    private String maintaiName;

    @Column(name = "MAINTAI_PHONE",length =32)
    private Long maintaiPhone;

    @Column(name = "LAST_MAINTAI_NAME",length =32)
    private Long lastMaintaiName;

    public int getWaterId() {
        return waterId;
    }

    public void setWaterId(int waterId) {
        this.waterId = waterId;
    }

    public int getWaterTypeId() {
        return waterTypeId;
    }

    public void setWaterTypeId(int waterTypeId) {
        this.waterTypeId = waterTypeId;
    }

    public String getWaterAddress() {
        return waterAddress;
    }

    public void setWaterAddress(String waterAddress) {
        this.waterAddress = waterAddress;
    }

    public String getWaterName() {
        return waterName;
    }

    public void setWaterName(String waterName) {
        this.waterName = waterName;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTroopId() {
        return troopId;
    }

    public void setTroopId(int troopId) {
        this.troopId = troopId;
    }

    public Long getMaintaiPhone() {
        return maintaiPhone;
    }

    public void setMaintaiPhone(Long maintaiPhone) {
        this.maintaiPhone = maintaiPhone;
    }

    public String getMaintaiName() {
        return maintaiName;
    }

    public void setMaintaiName(String maintaiName) {
        this.maintaiName = maintaiName;
    }

    public Long getLastMaintaiName() {
        return lastMaintaiName;
    }

    public void setLastMaintaiName(Long lastMaintaiName) {
        this.lastMaintaiName = lastMaintaiName;
    }
}
