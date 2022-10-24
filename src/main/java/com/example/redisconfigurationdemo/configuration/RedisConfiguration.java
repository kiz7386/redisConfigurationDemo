package com.example.redisconfigurationdemo.configuration;

import com.example.redisconfigurationdemo.component.redis.GateReceiver;
import com.example.redisconfigurationdemo.service.GatePublisherService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
//@AutoConfiguration("{GateReceiver.class}")
public class RedisConfiguration {

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic(GatePublisherService.TOPIC_USERNAME));
        return container;
    }

    @Bean
    public MessageListenerAdapter getMessageListenerAdapter(GateReceiver gateReceiver){
        return new MessageListenerAdapter(gateReceiver);
    }
}
