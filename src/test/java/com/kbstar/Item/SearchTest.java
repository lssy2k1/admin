package com.kbstar.Item;
import com.kbstar.dto.Item;
import com.kbstar.dto.ItemSearch;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SearchTest {
    @Autowired
    ItemService service;
    @Test
    void contextLoads(){
        ItemSearch itemSearch = new ItemSearch("반", 10000, "2023/04/01", "2023/05/08");
        try {
            service.search(itemSearch);
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
