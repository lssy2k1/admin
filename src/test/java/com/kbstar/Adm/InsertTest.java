package com.kbstar.Adm;

import com.kbstar.dto.Adm;
import com.kbstar.service.AdmService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@SpringBootTest
@Slf4j
class InsertTest {
    @Autowired
    AdmService service;
    @Test
    void contextLoads() {
        Adm obj = new Adm("id04", "pwd01", 1);
        Adm obj1 = new Adm("id05", "pwd02", 1);

        try {
            service.register(obj);
            service.register(obj1);
            log.info("등록정상");
        } catch (Exception e) {
            if(e instanceof DuplicateKeyException){
                log.info("아이디가 중복되었습니다===========================");
            }else {
                log.info("시스템 장애입니다.==============================");
                e.printStackTrace();
            }
        }
    }

}
