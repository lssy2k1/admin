package com.kbstar.markerDesc;
import com.kbstar.dto.MarkerDesc;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UpdateTest {
    @Autowired
    MarkerDescService service;
    @Test
    void contextLoads(){

        MarkerDesc obj = new MarkerDesc(14,107,"두붕",10,"yang1.jpg");
        try {
            service.modify(obj);
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
