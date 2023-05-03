package com.kbstar.markerDesc;
import com.kbstar.dto.MarkerDesc;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@SpringBootTest
@Slf4j
public class InsertTest {
    @Autowired
    MarkerDescService service;
    @Test
    void contextLoads(){
        MarkerDesc obj = new MarkerDesc(0,106,"돼지구이",1000,"yang.jpg");
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
