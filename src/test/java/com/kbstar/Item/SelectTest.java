package com.kbstar.Item;
import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SelectTest {
    @Autowired
    ItemService service;
    @Test
    void contextLoads(){
        List<Item> list = null;
        try {
            list=service.get();
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
