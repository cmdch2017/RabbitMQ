package com.example.consumer.listeners;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lst
 * @date 2023年05月12日 11:05
 */
@RestController
@RequestMapping("/user")
public class ConsumerController {
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg) {
        System.out.println("消费者接收到simple.queue的消息:" + "[" + msg + "]");
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1接收到work.queue的消息:" + "[" + msg + "]");
        Thread.sleep(20);
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.out.println("消费者2接收到work.queue的消息:" + "[" + msg + "]");
        Thread.sleep(200);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) {
        System.out.println("消费者1接收到fanout.queue1的消息:" + "[" + msg + "]");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) {
        System.out.println("消费者2接收到fanout.queue2的消息:" + "[" + msg + "]");
    }

    //    @RabbitListener(bindings = @QueueBinding(value=@Queue(name="direct.queue1",durable = "true"),exchange = @Exchange(name = "hmall.direct",type = ExchangeTypes.DIRECT),key={"red","blue"}))
//    public void listenDirectQueue1(String msg) {
//        System.out.println("消费者1接收到direct.queue1的消息:" + "[" + msg + "]");
//    }
//
//    @RabbitListener(bindings = @QueueBinding(value=@Queue(name="direct.queue2",durable = "true"),exchange = @Exchange(name = "hmall.direct",type = ExchangeTypes.DIRECT),key={"red","yellow"}))
//    public void listenDirectQueue2(String msg) {
//        System.out.println("消费者2接收到direct.queue2的消息:" + "[" + msg + "]");
//    }

    @RabbitListener(queues = "object.queue")
    public void listenFanoutQueue3(Map<String,Object> msg) {
        System.out.println("消费者3接收到object.queue的消息:" + "[" + msg + "]");
    }

    @RabbitListener(queues = "topic.queue1")
    public void listenTopicQueue1(String msg) {
        System.out.println("消费者1接收到topic.queue1的消息:" + "[" + msg + "]");
    }

    @RabbitListener(queues = "topic.queue2")
    public void listenTopicQueue2(String msg) {
        System.out.println("消费者2接收到topic.queue2的消息:" + "[" + msg + "]");
    }

}
