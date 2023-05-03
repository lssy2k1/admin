package com.kbstar.markerDesc;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SelectOneTest {
    @Autowired
    MarkerDescService service;
    @Test
    void contextLoads(){
        try {
            service.get(12);
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
