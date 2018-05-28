package com.gsitm.dao;

import com.gsitm.vo.ItemDetailVO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gsitm.vo.ItemVO;


@Repository(value = "itemDao")
public class ItemDao {
    private static final Logger logger = LoggerFactory.getLogger(ItemDao.class);

    @Autowired
    @Qualifier("sessionFactory2")
    private SessionFactory sessionFactory2;


    @SuppressWarnings("unchecked")
    public void insertItem(ItemVO item) {

        Session session = this.sessionFactory2.openSession();
        session.beginTransaction();
        session.saveOrUpdate(item);
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public void insertItemDetail(ItemDetailVO itemDetail) {

        Session session = this.sessionFactory2.openSession();
        session.beginTransaction();
        session.saveOrUpdate(itemDetail);
        session.getTransaction().commit();
        session.close();
    }

}
