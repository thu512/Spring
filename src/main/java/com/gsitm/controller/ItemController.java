package com.gsitm.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsitm.vo.ItemDetailVO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.gsitm.service.ItemService;
import com.gsitm.vo.ItemVO;

@Controller
public class ItemController {

    @Resource(name = "itemService")
    private ItemService itemService;

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @RequestMapping(value = "/getItemList.do", method = RequestMethod.GET)
    public ModelAndView Info(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
    		ModelAndView mv, ItemVO itemVO) throws Exception {
    	mv.setViewName("/itemList");//타일즈 view => 일반 view
        return mv;
        
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String getItemDetail(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                              Model model, ItemVO itemVO) throws Exception {

    	

    	return "index";
    }

}
