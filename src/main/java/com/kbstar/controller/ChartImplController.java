package com.kbstar.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ChartImplController {

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