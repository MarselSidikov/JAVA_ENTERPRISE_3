package ru.itis.stomp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import ru.itis.stomp.interceptors.HandShakeInterceptor;

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private HandShakeInterceptor handShakeInterceptor;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // endpoint с которым работают клиенты, они могут посылать сюда сообщения
        // они могут их отсюда получать
        registry.enableSimpleBroker("/topic");
        // сюда можно направлять сообшения, чтобы они попали в само приложение
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // сюда можно подключаться вебсокет-клиентам (stomp-клиент)
        registry.addEndpoint("/messages").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(handShakeInterceptor);
    }
}
