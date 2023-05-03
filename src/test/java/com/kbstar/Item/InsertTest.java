package com.kbstar.Item;
import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@SpringBootTest
@Slf4j
public class InsertTest {
    @Autowired
    ItemService service;
    @Test
    void contextLoads(){
        Item obj = new Item(0,"긴바지1",20000,"b.jpg",null);
        try {
            service.register(obj);
            service.get();
            log.info("아이템 등록 정상");
        } catch (Exception e) {
            if( e instanceof DuplicateKeyException) {
                log.info("ID가 중복 되었습니다.-----------------------------------------------------");
            }else {
                log.info("시스템 장애입니다.-----------------------------------------------------");
            }
        }
    }
}
