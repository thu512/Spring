package com.gsitm.dao;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gsitm.vo.ItemDetailVO;
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
    
    @SuppressWarnings("unchecked")
    public List<ItemDetailVO> getItemDetailList(String itemCode) {

        Session session = this.sessionFactory2.openSession();
        org.hibernate.Query query = session.
                createQuery("from ItemDetailVO where item_code=:itemCode");
        query.setParameter("itemCode", itemCode);
        List<ItemDetailVO> itemList = query.list();
        session.close();
        
        return itemList;
    }
    
    @SuppressWarnings("unchecked")
    public List<ItemDetailVO> getItemDetailList2() {

        Session session = this.sessionFactory2.openSession();
        List<ItemDetailVO> itemList = session.createQuery("from ItemDetailVO").list();
        session.close();
        
        return itemList;
    }
    
    @SuppressWarnings("unchecked")
    public int itemCnt(String itemCode) {

        Session session = this.sessionFactory2.openSession();
        int count = ((Long)session.createQuery("select count(*) from ItemDetailVO where item_code="+itemCode).uniqueResult()).intValue();
        session.close();
        return count;
    }
    
    @SuppressWarnings("unchecked")
    public List<ItemVO> getItemList() {

        Session session = this.sessionFactory2.openSession();
        List<ItemVO> itemList = session.createQuery("from ItemVO").list();
        session.close();
        
        return itemList;
    }

}
