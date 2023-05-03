package com.kbstar.Cust;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UpdateTest {
    @Autowired
    CustService service;
    @Test
    void contextLoads() {
        Cust obj = new Cust("id011", "pwd10", "jamesModify");
        try {
            service.modify(obj);
            log.info("등록정상");
        } catch (Exception e) {
                log.info("시스템 장애입니다.==============================");
                e.printStackTrace();
        }
    }

}
