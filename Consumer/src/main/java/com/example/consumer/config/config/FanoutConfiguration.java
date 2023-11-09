package com.example.consumer.config.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lst
 * @date 2023年11月09日 11:03
 */
//@Configuration
//public class FanoutConfiguration {
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return ExchangeBuilder.fanoutExchange("hmall.fanout2").build();
//    }
//
//    @Bean
//    public Queue fanoutQueue3() {
//        return QueueBuilder.durable("fanout.queue3").build();
//    }
//
//    @Bean
//    public Binding fanoutBinding3() {
//        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
//    }
//
//    @Bean
//    public Queue fanoutQueue4() {
//        return QueueBuilder.durable("fanout.queue4").build();
//    }
//
//    @Bean
//    public Binding fanoutBinding4() {
//        return BindingBuilder.bind(fanoutQueue4()).to(fanoutExchange());
//    }
//}
