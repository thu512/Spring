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

import com.google.gson.Gson;
import com.gsitm.service.ItemService;
import com.gsitm.vo.ItemVO;

@Controller
public class ItemController {

    @Resource(name = "itemService")
    private ItemService itemService;

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @RequestMapping(value = "/getItemList.do", method = RequestMethod.GET)
    public void Info(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                     Model model, ItemVO itemVO) throws Exception {

        String serviceKey = "QuZgRdiKTWvGqdxo5L%2Fp8GgyI%2B8Rhq95smUbZd9SyM4I9mxF47WUeR%2BWaPIvMbPFnYekApVVQ%2FDlZyQgDrddGQ%3D%3D";

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(1000 * 60 * 5); // 5분
        factory.setConnectTimeout(5000);
        RestTemplate restTemplate = new RestTemplate(factory);
        String url = "http://data.insight.go.kr:8080/openapi/service/PriceItemList/getPriceItemList?ServiceKey=QuZgRdiKTWvGqdxo5L%2Fp8GgyI%2B8Rhq95smUbZd9SyM4I9mxF47WUeR%2BWaPIvMbPFnYekApVVQ%2FDlZyQgDrddGQ%3D%3D";
        URI uri = new URI(url);

        String itemXML = restTemplate.getForObject(uri, String.class);

        org.json.JSONArray xmlJSONObj = XML.toJSONObject(itemXML).getJSONObject("response").getJSONObject("body")
                .getJSONObject("items").getJSONArray("item");

        Gson gson = new Gson();
        ItemVO[] itemVOs = gson.fromJson(xmlJSONObj.toString(), ItemVO[].class);
        List<ItemVO> items = Arrays.asList(itemVOs);
        logger.info(items.toString());

        itemService.insertItem(items);

        Calendar oCalendar = Calendar.getInstance();

        int year = oCalendar.get(Calendar.YEAR);//str.split("-")[0];
        int month = oCalendar.get(Calendar.MONTH) + 1;
        String day = "01";
        String m = "";

        if (month == 1) {
            m = "12";
        } else {
            if (month - 1 < 10) {
                m = "0" + String.valueOf(month - 1);
            } else {
                m = String.valueOf(month - 1);
            }
        }
        logger.info("" + year + "" + m + "" + day);

        String date = "" + year + "" + m + "" + day;
        for(ItemVO item : items){
            String url2 ="http://data.insight.go.kr:8080/openapi/service/PriceInfo/getPriceInfo?ServiceKey=QuZgRdiKTWvGqdxo5L%2Fp8GgyI%2B8Rhq95smUbZd9SyM4I9mxF47WUeR%2BWaPIvMbPFnYekApVVQ%2FDlZyQgDrddGQ%3D%3D&itemCode="+item.getIc()+"&startDate="+date+"&endDate="+date+"pageNo=1&numOfRows=50";
            uri = new URI(url2);
            itemXML = restTemplate.getForObject(uri, String.class);

            JSONObject xmlJSONObj2 = XML.toJSONObject(itemXML);
            if(xmlJSONObj2.has("response")) {
            	xmlJSONObj2=xmlJSONObj2.getJSONObject("response");
            	if(xmlJSONObj2.has("body")){
                    JSONArray jsonArray = xmlJSONObj2.getJSONObject("body").getJSONObject("items").getJSONArray("item");
                    gson = new Gson();
                    ItemDetailVO[] itemDetailVOs = gson.fromJson(jsonArray.toString(), ItemDetailVO[].class);
                    List<ItemDetailVO> itemsDetail = Arrays.asList(itemDetailVOs);
                    logger.info(itemsDetail.toString());
                    itemService.insertItemDetail(itemsDetail, item.getIc());
                }
            }
            
        }

        //itemService.insertItemDetail();

    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String getItemDetail(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                              Model model, ItemVO itemVO) throws Exception {

    	

    	return "index";
    }

}
