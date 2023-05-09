package com.kbstar.controller;

import com.kbstar.dto.Cart;
import com.kbstar.dto.MsgAdm;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//import com.multi.vo.Msg;

import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class ScheduleController {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @Autowired
    CartService cartService;

    @Scheduled(cron = "*/55 * * * * *")
    public void cronJobDailyUpdate() {

//        log.info("----------- Scheduler ------------");
        Random r = new Random();
        int content1 = r.nextInt(100) + 1;
        int content2 = r.nextInt(1000) + 1;
        int content3 = r.nextInt(500) + 1;
        int content4 = r.nextInt(10) + 1;

        MsgAdm msg = new MsgAdm();
        msg.setContent1(content1);
        msg.setContent2(content2);
        msg.setContent3(content3);
        msg.setContent4(content4);
        messagingTemplate.convertAndSend("/sendadm",msg);

//        messagingTemplate.convertAndSend("/send", msg);
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void cronJobWeeklyUpdate() throws Exception {
//        List<Cart> cartList = cartService.get();
//        int sum = 0;
//        for(Cart obj: cartList){
//            sum += obj.getItem_price() * obj.getCnt();
//        }
//        log.info(sum+"");

//        카트기능 써머라이즈
//        mapper, service를 가져와야 함.
//        cart에 가격을 넣으면
        int sum = cartService.getallprice();
        log.info(sum +"");
    }


}