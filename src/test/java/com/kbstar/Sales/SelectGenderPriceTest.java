package com.kbstar.Sales;

import com.kbstar.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class SelectGenderPriceTest {

    @Autowired
    SalesService service;
    @Test
void contextLoads() {

    try {
//        List<Integer> monthlyPrice = service.getMonthlyPrice();
//        for(Integer obj:monthlyPrice){
//            log.info(obj + "");
//        }
        List<Integer> serviceGenderPrice = service.getGenderPrice("m");
        for(Integer obj:serviceGenderPrice){
            log.info(obj + "");
        }
    } catch (Exception e) {
        log.info("조회 에러......");
        e.printStackTrace();
        }
    }
}

