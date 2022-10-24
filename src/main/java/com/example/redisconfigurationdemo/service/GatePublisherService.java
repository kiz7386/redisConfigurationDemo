package com.example.redisconfigurationdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class GatePublisherService {

    public final static String TOPIC_USERNAME= "TOPIC_USERNAME";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String sendMessage(String name){
        try {

            stringRedisTemplate.convertAndSend(TOPIC_USERNAME, name);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }

    }

}
