package com.example.redisconfigurationdemo.controller;


import com.example.redisconfigurationdemo.service.GatePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatePublisherController {

    @Autowired
    private GatePublisherService service;

    @RequestMapping("{name}")
    public String sendMessage(@PathVariable String name){
        return service.sendMessage(name);
    }

}
