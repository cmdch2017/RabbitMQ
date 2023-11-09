package com.example.provider.wego.controller;

import com.example.provider.wego.domain.User;
import com.example.provider.wego.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lst
 * @date 2023年05月12日 11:05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("getAllUser")
    public List<User> getAllUser() {
        return userService.list();
    }

    @PostMapping("insertUser")
    public Boolean insertUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping("deleteUser")
    public Boolean deleteUser(User user) {
        return userService.removeById(user);
    }

//    @PostConstruct
//    public void testSendMessage2SimpleQueue(){
//        String queueName="simple.queue";
//        String message="hello,Spring amqp!";
//        rabbitTemplate.convertAndSend(queueName,message);
//    }

    //    @PostConstruct
//    public void testSendMessage2WorkQueue() throws InterruptedException {
//        String queueName = "work.queue";
//        for (int message = 0; message < 50; message++) {
//            rabbitTemplate.convertAndSend(queueName, message);
//            Thread.sleep(20);
//        }
//    }
//    @PostConstruct
//    public void testSendMessage2FanoutQueue() throws InterruptedException {
//        String exchangeName = "hmall.fanout";
//        String message = "hello,Spring amqp!";
//        rabbitTemplate.convertAndSend(exchangeName, null, message);
//    }
//    @PostConstruct
//    public void testSendMessage2DirectQueue() {
//        String exchangeName = "hmall.direct";
//        String key="yellow";
//        String message = "hello,Spring amqp!";
//        rabbitTemplate.convertAndSend(exchangeName, key, message);
//    }
//    @PostConstruct
//    public void testSendMessage2TopicQueue() {
//        String exchangeName = "hmall.topic";
//        String key="china.news";
//        String message = "hello,Spring amqp!";
//        rabbitTemplate.convertAndSend(exchangeName, key, message);
//    }
    @PostConstruct
    public void testSendObject() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", "hello,Spring amqp!");
        map.put("age",10);
        rabbitTemplate.convertAndSend( "object.queue", map);
    }
}
