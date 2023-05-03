package com.kbstar.Sales;

import com.kbstar.dto.Sales;
import com.kbstar.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest
class InsertTest {

    @Autowired
    SalesService service;
    @Test
    void contextLoads() {
        Date date =  new Date();
        Sales obj = new Sales("2023-11-11",20,"M");
        try {
            service.register(obj);
            service.get();
            log.info("Sales가 등록이 되었다");
        } catch (Exception e) {
            log.info("등록 에러........................................");
            e.printStackTrace();
        }
    }
}
