package com.gsitm.batch;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.gsitm.service.ItemService;
import com.gsitm.vo.ItemDetailVO;
import com.gsitm.vo.ItemVO;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ExBatchJob {

    @Resource(name = "itemService")
    private ItemService itemService;

    private static final Logger logger = LoggerFactory.getLogger(ExBatchJob.class);

    public void doBatch() throws Exception {

        logger.info("=ExBatchJob 배치============"
                + Calendar.getInstance(Locale.KOREA).get(Calendar.HOUR_OF_DAY) + "시="
                + Calendar.getInstance(Locale.KOREA).get(Calendar.MINUTE) + "분=");
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
        for (ItemVO item : items) {
            logger.info("item_code " + item.getIc());
            String url2 = "http://data.insight.go.kr:8080/openapi/service/PriceInfo/getPriceInfo?ServiceKey=QuZgRdiKTWvGqdxo5L%2Fp8GgyI%2B8Rhq95smUbZd9SyM4I9mxF47WUeR%2BWaPIvMbPFnYekApVVQ%2FDlZyQgDrddGQ%3D%3D&itemCode=" + item.getIc() + "&startDate=" + date + "&endDate=" + date + "&pageNo=1&numOfRows=30";
            uri = new URI(url2);
            itemXML = restTemplate.getForObject(uri, String.class);

            JSONObject xmlJSONObj2 = XML.toJSONObject(itemXML);
            if (xmlJSONObj2.has("response")) {
                xmlJSONObj2 = xmlJSONObj2.getJSONObject("response");
                if (xmlJSONObj2.has("body")) {
                    JSONArray jsonArray = xmlJSONObj2.getJSONObject("body").getJSONObject("items").getJSONArray("item");
                    List<ItemDetailVO> itemsDetail = new ArrayList<ItemDetailVO>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject json = jsonArray.getJSONObject(i);
                        if (!json.get("dp").equals("")) {
                            ItemDetailVO it = gson.fromJson(json.toString(), ItemDetailVO.class);
                            itemsDetail.add(it);
                        }
                    }
                    if (itemsDetail.size() > 0) {
                        logger.info(itemsDetail.toString());
                        itemService.insertItemDetail(itemsDetail, item.getIc());
                    }

                }
            }

        }
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ExBatchJob proc = new ExBatchJob();
        proc.doBatch();
    }
}
