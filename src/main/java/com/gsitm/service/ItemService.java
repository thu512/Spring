package com.gsitm.service;

import java.util.List;

import javax.annotation.Resource;

import com.gsitm.vo.ItemDetailVO;
import org.springframework.stereotype.Service;

import com.gsitm.dao.ItemDao;
import com.gsitm.vo.ItemVO;

@Service(value = "itemService")
public class ItemService {

    @Resource(name = "itemDao")
    private ItemDao itemDao;

    public void insertItem(List<ItemVO> items) throws Exception {
        for (ItemVO item : items) {
            itemDao.insertItem(item);
        }
    }

    public void insertItemDetail(List<ItemDetailVO> items, String ic) throws Exception{
        for (ItemDetailVO item : items) {
            item.setIc(ic);
            itemDao.insertItemDetail(item);
        }
    }

//	
//	public BoardVO read(BoardVO boardVO) throws Exception{
//
//		BoardVO result = BoardDao.read(boardVO);
//		return result;
//	}	
}