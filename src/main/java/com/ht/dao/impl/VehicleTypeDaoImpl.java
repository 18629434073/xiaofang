package com.ht.dao.impl;

import com.ht.dao.IVehicleTypeDao;
import com.ht.dao.IWaterTypeDao;
import com.ht.model.VehicleType;
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
public class VehicleTypeDaoImpl implements IVehicleTypeDao {
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public Pagination getVehicleTypeList(Pagination page) {
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT t.* FROM TB_VEHICLE_TYPE t");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.addEntity(VehicleType.class);
        List<VehicleType> list=(List<VehicleType>)query.list();
        int recordTotal= CommonUtils.getRecordCount(sql.toString(),sessionFactory);
        page.setRecordTotal(recordTotal);
        page.setList(list);
        return page;
    }

    @Override
    public void saveVehicleType(VehicleType vehicleType) {
            sessionFactory.getCurrentSession().save(vehicleType);
    }

    @Override
    public void delteVehicleType(String id) {
        StringBuffer sql=new StringBuffer();
        sql.append("DELETE FROM TB_VEHICLE_TYPE WHERE VEHICLE_TYPE_ID=?");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.setString(0,id);
        query.executeUpdate();
    }

    @Override
    public VehicleType getVehicleType(String id) {
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT t.* FROM TB_VEHICLE_TYPE t WHERE t.VEHICLE_TYPE_ID=?");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.setString(0,id);
        query.addEntity(VehicleType.class);
        return (VehicleType) query.list().get(0);
    }

    @Override
    public void updateVehicleType(VehicleType vehicleType) {
        sessionFactory.getCurrentSession().update(vehicleType);
        sessionFactory.getCurrentSession().flush();
    }
}
