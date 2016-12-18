package com.ht.dao.impl;

import com.ht.dao.IUserDao;
import com.ht.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by UPC on 2016/12/10.
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;
    @Override
    public User getUser(String userid) {
        StringBuffer hql=new StringBuffer();
        hql.append("from SYSTEM_USER u WHERE u.userId=?");
        Query query=sessionFactory.getCurrentSession().createQuery(hql.toString());
        query.setString(0,userid);
        List<User> list=query.list();
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
