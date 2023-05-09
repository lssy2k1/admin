package com.kbstar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration
public class StomWebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Value("${serviceserver}")
    String serviceServer;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("http://127.0.0.1", serviceServer).withSockJS();
        registry.addEndpoint("/chbot").setAllowedOrigins("http://127.0.0.1").withSockJS();
        registry.addEndpoint("/wss").setAllowedOrigins("http://127.0.0.1").withSockJS();
    }
//setAllowedOrigin은 127.0.0.1로 접속했던 브라우저도 소켓 사용가능하게 함.
    /* 어플리케이션 내부에서 사용할 path를 지정할 수 있음 */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/send","/sendadm");
    }
    //각각 send, broadcast는 inbound, outbound
    // send는 클라이언트가 서버로 보낼 떄, broadcasat는 서버가 클라이언트로 보낼 때
}