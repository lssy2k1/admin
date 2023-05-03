package com.kbstar.Cust;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@SpringBootTest
@Slf4j
class InsertTest {
    @Autowired
    CustService service;
    @Test
    void contextLoads() {
        Cust obj = new Cust("id233", "pwd21", "james21");
        try {
            service.register(obj);
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
