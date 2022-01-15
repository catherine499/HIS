package com.example.HIS.start;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


//@Component
//public class TestConsumer {
//
//    @KafkaListener(topics = "yhtest") //定义此消费者接收topic为“test_topic”的消息
////    监听服务器上的kafka是否有相关的消息发过来
////    record变量代表消息本身，可以通过ConsumerRecord<?,?>类型的record变量来打印接收的消息的各种信息
//    public void listen(ConsumerRecord<?, ?> record) throws Exception {
//        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
//    }
//
//}