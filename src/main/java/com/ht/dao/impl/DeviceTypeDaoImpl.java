package com.ht.dao.impl;

import com.ht.dao.IDeviceTypeDao;
import com.ht.dao.IWaterTypeDao;
import com.ht.model.DeviceType;
import com.ht.model.WaterType;
import com.ht.model.filters.Pagination;
import com.ht.util.CommonUtils;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by de on 2016/12/15.
 */
@Repository
public class DeviceTypeDaoImpl implements IDeviceTypeDao {
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public Pagination getDeviceTypeList(Pagination page) {
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT t.* FROM TB_DEVICE_TYPE t");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.addEntity(DeviceType.class);
        List<DeviceType> list=(List<DeviceType>)query.list();
        int recordTotal= CommonUtils.getRecordCount(sql.toString(),sessionFactory);
        page.setRecordTotal(recordTotal);
        page.setList(list);
        return page;
    }

    @Override
    public void saveDeviceType(DeviceType deviceType) {
            sessionFactory.getCurrentSession().save(deviceType);
    }

    @Override
    public void delteDeviceType(String id) {
        StringBuffer sql=new StringBuffer();
        sql.append("DELETE FROM TB_DEVICE_TYPE WHERE DEVICE_TYPE_ID=?");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.setString(0,id);
        query.executeUpdate();
    }

    @Override
    public DeviceType getDeviceType(String id) {
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT t.* FROM TB_DEVICE_TYPE t WHERE t.DEVICE_TYPE_ID=?");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.setString(0,id);
        query.addEntity(DeviceType.class);
        return (DeviceType) query.list().get(0);
    }

    @Override
    public void updateDeviceType(DeviceType deviceType) {
        sessionFactory.getCurrentSession().update(deviceType);
        sessionFactory.getCurrentSession().flush();
    }
}
