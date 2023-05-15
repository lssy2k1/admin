package com.kbstar.controller;

import com.kbstar.dto.Msg;
import com.kbstar.util.ChatBotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class ChatbotController {
    @Autowired
    SimpMessagingTemplate template;

    @MessageMapping("/chatbotme") // 특정 Id에게 전송
    public void chatbotme(Msg msg, SimpMessageHeaderAccessor headerAccessor) throws IOException {
        String target = msg.getSendid();
        String txt = msg.getContent1();//채팅하자 라고 msg에 넣은 것을 꺼낼게
        String result = ChatBotUtil.chat(txt);//꺼낸걸 chatbot에 넣어서 답변을 받을게
        msg.setContent1(result);//결과를 메세지에 담아서 보낼게
        template.convertAndSend("/chsend/"+target,msg);
    }
}
