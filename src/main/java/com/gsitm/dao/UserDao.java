package com.gsitm.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gsitm.vo.ItemDetailVO;
import com.gsitm.vo.ItemVO;
import com.gsitm.vo.UserVO;


@Repository(value = "userDao")
public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(ItemDao.class);

    @Autowired
    @Qualifier("sessionFactory2")
    private SessionFactory sessionFactory2;


//    @SuppressWarnings("unchecked")
//    public void insertItem(ItemVO item) {
//
//        Session session = this.sessionFactory2.openSession();
//        session.beginTransaction();
//        session.saveOrUpdate(item);
//        session.getTransaction().commit();
//        session.close();
//    }

    
    
    @SuppressWarnings("unchecked")
    public UserVO getUser(String id) {

        Session session = this.sessionFactory2.openSession();
        org.hibernate.Query query = session.
                createQuery("from UserVO where id=:id");
        query.setParameter("id", id);
        List<UserVO> userList = query.list();
        session.close();
        
        return userList.get(0);
    }
    
    

}
