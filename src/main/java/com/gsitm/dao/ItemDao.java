package com.gsitm.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gsitm.vo.Chart;
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
    
    
    
    @SuppressWarnings("unchecked")
    public List<Chart> getChart() {

        Session session = this.sessionFactory2.openSession();

        String sql = "select i.item_name itemName, round(avg(d.SALE_PRICE),0) avgPrice from itemdetailvo d join itemvo i on I.ITEM_CODE=D.ITEM_CODE  where to_char(d.sale_date,'MM')='04' group by d.item_code, i.item_name";
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List data1 = query.list();
        List<Chart> data = new ArrayList<Chart>();
        for(Object object : data1) {
           Map row = (Map)object;
           logger.info(row.toString());
           data.add(new Chart(row.get("ITEMNAME").toString(), Integer.parseInt(row.get("AVGPRICE").toString())));
           
        }
        session.close();
        
        logger.info(data.toString());
        return data;
    }
    
    
    @SuppressWarnings("unchecked")
    public List<Chart> getChart2() {

        Session session = this.sessionFactory2.openSession();

        String sql = "select i.item_name itemName, round(avg(d.SALE_PRICE),0) avgPrice from itemdetailvo d join itemvo i on I.ITEM_CODE=D.ITEM_CODE  where to_char(d.sale_date,'MM')='03' group by d.item_code, i.item_name";
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List data1 = query.list();
        List<Chart> data = new ArrayList<Chart>();
        for(Object object : data1) {
           Map row = (Map)object;
           logger.info(row.toString());
           data.add(new Chart(row.get("ITEMNAME").toString(), Integer.parseInt(row.get("AVGPRICE").toString())));
           
        }
        session.close();
        
        logger.info(data.toString());
        return data;
    }
}
