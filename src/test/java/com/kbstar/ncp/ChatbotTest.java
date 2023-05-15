package com.kbstar.ncp;

import com.kbstar.util.ChatBotUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
class ChatbotTest {

    @Test
    void contextLoads() throws IOException {
        String txt = "이런 18";
        String result = ChatBotUtil.chat(txt);
        log.info("==============================================");
        log.info(result);
        log.info("==============================================");
    }

}
