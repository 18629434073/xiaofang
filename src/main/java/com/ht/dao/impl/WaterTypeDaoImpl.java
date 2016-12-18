package com.ht.dao.impl;

import com.ht.dao.IWaterTypeDao;
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
public class WaterTypeDaoImpl implements IWaterTypeDao {
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public Pagination getWaterTypeList(Pagination page) {
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT t.* FROM TB_WATER_TYPE t");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.addEntity(WaterType.class);
        List<WaterType> list=(List<WaterType>)query.list();
        int recordTotal= CommonUtils.getRecordCount(sql.toString(),sessionFactory);
        page.setRecordTotal(recordTotal);
        page.setList(list);
        return page;
    }

    @Override
    public void saveWaterType(WaterType waterType) {
            sessionFactory.getCurrentSession().save(waterType);
    }

    @Override
    public void delteWaterType(String id) {
        StringBuffer sql=new StringBuffer();
        sql.append("DELETE FROM TB_WATER_TYPE WHERE WATER_TYPE_ID=?");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.setString(0,id);
        query.executeUpdate();
    }

    @Override
    public WaterType getWaterType(String id) {
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT t.* FROM TB_WATER_TYPE t WHERE t.WATER_TYPE_ID=?");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
        query.setString(0,id);
        query.addEntity(WaterType.class);
        return (WaterType) query.list().get(0);
    }

    @Override
    public void updateWaterType(WaterType waterType) {
        sessionFactory.getCurrentSession().update(waterType);
        sessionFactory.getCurrentSession().flush();
    }
}
