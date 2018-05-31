package com.gsitm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gsitm.vo.Chart;
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

	public void insertItemDetail(List<ItemDetailVO> items, String ic) throws Exception {
		for (ItemDetailVO item : items) {
			item.setIc(ic);
			itemDao.insertItemDetail(item);
		}
	}

	// 
	public List<ItemDetailVO> getItemDetailList(String itemCode) throws Exception {
		if(itemCode == null) {
			return itemDao.getItemDetailList2();
		}else {
			return itemDao.getItemDetailList(itemCode);
		}
	}

	public List<ItemVO> getItemList() throws Exception {

		return itemDao.getItemList();
	}
	
	public int itemCnt(String itemCode) {
		return itemDao.itemCnt(itemCode);
	}
	
	
	
	public List<Chart> getChart() {
		return itemDao.getChart();
	}
	public List<Chart> getChart2() {
		return itemDao.getChart2();
	}
}