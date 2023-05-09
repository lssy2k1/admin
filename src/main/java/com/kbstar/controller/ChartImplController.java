package com.kbstar.controller;

import com.kbstar.dto.Sales;
import com.kbstar.service.SalesService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class ChartImplController {
    @Autowired
    SalesService salesService;

    @Scheduled(cron = "*/5 * * * * *")
    @RequestMapping("/centerchart01")
    public Object centerchart01() throws Exception {
        List<Integer> list = salesService.getMonthlyPrice();
        JSONArray jaTotalPrice = new JSONArray();
        for (Integer obj: list){
            jaTotalPrice.add(obj);
        }
        return jaTotalPrice;
    }
    @Scheduled(cron = "*/5 * * * * *")
    @RequestMapping("/centerchart02")
    public Object centerchart02() throws Exception {
        List<Integer> listM = salesService.getGenderPrice("M");
        List<Integer> listF = salesService.getGenderPrice("F");
        List<Sales> salesList = salesService.get();

        JSONObject jo = new JSONObject();
        JSONArray jaGender = new JSONArray();
        JSONArray jaMonth = new JSONArray();
        JSONArray jaM = new JSONArray();
        JSONArray jaF = new JSONArray();
        JSONObject joM = new JSONObject();
        JSONObject joF = new JSONObject();
        for(Sales obj: salesList){
            jaMonth.add(obj.getRdate());
        }
        for(Integer obj:listM){
            jaM.add(obj);
        }
        for(Integer obj:listF){
            jaF.add(obj);
        }
        joM.put("name", "Male");
        joM.put("data", jaM);

        joF.put("name", "FeMale");
        joF.put("data", jaF);

        jaGender.add(joM);
        jaGender.add(joF);

        jo.put("month", jaMonth);
        jo.put("price", jaGender);

        return jo;
    }
    @RequestMapping("/chartImpl01")
    public Object chartImpl01(){
        JSONArray jaa = new JSONArray();
        //{ {name, data[9개]}, {}...}

        for(int j = 0; j < 5; j++) {
            JSONObject jo = new JSONObject();
            JSONArray jaData = new JSONArray();
            Random r = new Random();
            for (int i = 0; i < 9; i++) {
                Random r1 = new Random();
                int inx = r1.nextInt(3000) + 100;
                jaData.add(inx);
            }
            jo.put("name", "name" + r.nextInt());
            jo.put("data", jaData);
            jaa.add(jo);
        }

        return jaa;
    }
    @RequestMapping("/chartImpl02")
    public Object chartImpl02(){
        JSONObject jo = new JSONObject();
        JSONArray male = new JSONArray();
        JSONArray female = new JSONArray();
        for(int i = 0; i < 17; i++){
            Random r = new Random();
            int inx = r.nextInt(10);
            male.add(-inx);
        }
        for(int i = 0; i < 17; i++){
            Random r = new Random();
            int inx = r.nextInt(10);
            female.add(inx);
        }
        jo.put("male", male);
        jo.put("female", female);
        return jo;
    }
    @RequestMapping("/chartImpl03")
    public Object chartImpl03(){
        JSONObject jo = new JSONObject();
        JSONArray ronaldo = new JSONArray();
        JSONArray messi = new JSONArray();
        JSONArray lewan = new JSONArray();
        for(int i = 0; i < 5; i++){
            Random r = new Random();
            int inx = r.nextInt(5);
            ronaldo.add(inx);
            int inx2 = r.nextInt(10);
            messi.add(inx2);
            int inx3 = r.nextInt(3);
            lewan.add(inx3);
        }
        jo.put("ronaldo", ronaldo);
        jo.put("messi", messi);
        jo.put("lewan", lewan);
        return jo;
    }
}