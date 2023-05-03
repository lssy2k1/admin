package com.kbstar.Cart;

import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@SpringBootTest
@Slf4j
class InsertTest {
    @Autowired
    CartService service;
    @Test
    void contextLoads() {
        Cart obj = new Cart("id21", 102, 2220);
        Cart obj1 = new Cart("id21", 102, 2220);
        Cart obj2 = new Cart("id21", 102, 2220);
        Cart obj3 = new Cart("id21", 102, 2220);
        try {
            service.register(obj);
            service.register(obj1);
            service.register(obj2);
            service.register(obj3);
            service.get();
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
