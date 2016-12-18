package com.ht.dao.impl;

import com.ht.dao.IUserDao;
import com.ht.dao.IWaterDao;
import com.ht.model.User;
import com.ht.model.Water;
import com.ht.model.filters.Pagination;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by UPC on 2016/12/10.
 */
@Repository
public class WaterDaoImpl implements IWaterDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public List<Water> getWaterList(Water water, Pagination page) {
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT t.* FROM tb_water t WHERE 1=1");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.addEntity(Water.class);
        return  (List<Water>)query.setFirstResult(page.getCurrent().intValue() * page.getRecordPage().intValue()).setMaxResults(page.getRecordPage().intValue()).list();
    }

    @Override
    public void saveWaterlocation(Water water) {
        sessionFactory.getCurrentSession().save(water);
    }

    @Override
    public void updateWaterlocation(Water water) {
        StringBuffer sql=new StringBuffer();
        sql.append("UPDATE TB_WATER t SET t.WATER_NAME=?,t.WATER_TYPE_ID=?,t.WATER_ADDRESS=?,t.LONGTITUDE=?,t.LATITUDE=?,t.STATUS=?,t.TROOP_ID=? WHERE t.WAYER_ID=?");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.setString(0,water.getWaterName());
        query.setInteger(1,water.getWaterTypeId());
        query.setString(2,water.getWaterAddress());
        query.setFloat(3,water.getLongtitude());
        query.setFloat(4,water.getLatitude());
        query.setInteger(5,water.getStatus());
        query.setInteger(6,water.getTroopId());
        query.setInteger(7,water.getWaterId());
        query.executeUpdate();
    }

    @Override
    public Water getWater(String id) {
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT t.* FROM tb_water t WHERE t.WATER_ID=?");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.setInteger(0,Integer.parseInt(id));
        query.addEntity(Water.class);
        List<Water> list=(List<Water>)query.list();
        return  list.size()>0?list.get(0):null;
    }

    @Override
    public void deleteWaterlocation(String ids) {
        for(String id:ids.split(",")){
            StringBuffer sql=new StringBuffer();
            sql.append("DELETE FROM tb_water t WHERE t.WATER_ID=?");
            SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
            query.setInteger(0,Integer.parseInt(id));
            query.executeUpdate();
        }
    }
}
