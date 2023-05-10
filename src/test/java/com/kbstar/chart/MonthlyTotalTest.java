package com.kbstar.chart;
import com.kbstar.dto.Chart;
import com.kbstar.dto.ItemSearch;
import com.kbstar.service.ChartService;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MonthlyTotalTest {
    @Autowired
    ChartService service;
    @Test
    void contextLoads(){
        //[{},{}]
        try {
            List<Chart> list = service.getMonthlyTotal();
            JSONArray fma = new JSONArray();
            JSONArray ma = new JSONArray();

            for(Chart obj:list){
                if(obj.getGender().toUpperCase().equals("F")){
                    fma.add(obj.getTotal());
                }else{
                    ma.add(obj.getTotal());
                }
                JSONObject fmo = new JSONObject();
                JSONObject mo = new JSONObject();
                fmo.put("name", "Female");
                fmo.put("data", fma);
                mo.put("name", "male");
                mo.put("data", ma);
                JSONArray data = new JSONArray();
                data.add(fmo);
                data.add(mo);
                log.info(data.toJSONString());
            }
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
