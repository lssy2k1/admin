package com.kbstar.Adm;

import com.kbstar.dto.Adm;
import com.kbstar.service.AdmService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UpdateTest {
    @Autowired
    AdmService service;
    @Test
    void contextLoads() {
        Adm obj = new Adm("id05", "pwd10", 11);
        try {
            service.modify(obj);
            log.info("등록정상");
        } catch (Exception e) {
                log.info("시스템 장애입니다.==============================");
                e.printStackTrace();
        }
    }

}
