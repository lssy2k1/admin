package com.kbstar.Cust;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SelectOneTest {
    @Autowired
    CustService service;
    @Test
    void contextLoads() {
        Cust cust = null;
        try {
            cust = service.get("id77");
            log.info("==================================");
            log.info(cust.toString());
            //줄이 하나밖에 안찍히고 오류가 났어 => Null이 들어왔을 때 오류가 남.
            log.info("==================================");
        } catch (Exception e) {
            log.info("시스템 장애입니다.==============================");
                e.printStackTrace();
            }
    }

}
