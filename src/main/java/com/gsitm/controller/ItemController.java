package com.gsitm.controller;

import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.gsitm.service.ItemService;
import com.gsitm.vo.DatatablesVO;
import com.gsitm.vo.ItemDetailVO;
import com.gsitm.vo.ItemVO;
import com.gsitm.vo.NaverItemVO;

@Controller
public class ItemController {

    @Resource(name = "itemService")
    private ItemService itemService;

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @RequestMapping(value = "/getItemList.do", method = RequestMethod.GET)
    public ModelAndView Info(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                             ModelAndView mv, ItemVO itemVO) throws Exception {
    	
    	logger.info("itemList  "+itemService.getItemList().toString());
    	mv.addObject("itemList", itemService.getItemList());
        mv.setViewName("/itemList");//타일즈 view => 일반 view
        return mv;

    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String getItemDetail(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                Model model, ItemVO itemVO) throws Exception {


        return "index";
    }
    
  //데이터 테이블 처리
  	@RequestMapping(value="/getItemDT.do", method = RequestMethod.POST)
  	public ModelAndView getItemDT(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param, Model model, ItemVO itemVO, DatatablesVO dtVO) throws Exception {
  		
  		
  		String itemCode = request.getParameter("itemCode");
  		
  		List<ItemDetailVO> itemList = itemService.getItemDetailList(itemCode);
  		///logger.info("리스트 "+itemList.toString());
  		//int totalCnt = itemService.itemCnt(itemCode);
  		
  		Map map = new HashMap();
  		map.put("aaData", itemList);
//  		map.put("iTotalRecords",totalCnt);
//  		map.put("iTotalDisplayRecords",totalCnt);
//  		map.put("sEcho",request.getParameter("sEcho"));

  		

  		return new ModelAndView("jsonView", map);
  	}
  	
  	
  	@RequestMapping(value="/getNaver.do", method = RequestMethod.GET)
  	public ModelAndView getNaver(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param, Model model, ItemVO itemVO, DatatablesVO dtVO) throws Exception {
  		request.setCharacterEncoding("utf-8");

  		logger.info("파라미터"+request.getParameter("pn"));
  		
  		HttpHeaders header = new HttpHeaders(); 
  		header.add("X-Naver-Client-Id", "VrlWaXO5ekWFGN2uNv4Z");
  		header.add("X-Naver-Client-Secret", "7sHvpho2LE");
  		

  		
  		
  		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(1000 * 60 * 5); // 5분
        factory.setConnectTimeout(5000);
        RestTemplate restTemplate = new RestTemplate(factory);
        String url = "https://openapi.naver.com/v1/search/shop.json?query="+URLEncoder.encode(request.getParameter("pn"), "UTF-8");
        URI uri = new URI(url);
        
        ResponseEntity<String> res = new RestTemplate().exchange(uri,HttpMethod.GET,new HttpEntity(header), String.class);
  		logger.info("네이버: "+res.getBody());
  		Gson gson = new Gson();
  		
  		JSONObject json = new JSONObject(res.getBody());
  		json.getJSONArray("items");
  		
        NaverItemVO[] naverItemVOs = gson.fromJson(json.getJSONArray("items").toString(), NaverItemVO[].class);
        List<NaverItemVO> items = Arrays.asList(naverItemVOs);
        logger.info(items.toString());
  		
  		return null;
  	}

}
