package kr.farmstoryapiserver.springkafkaconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class KafkaConsumerService {

    // topic1
    @KafkaListener(topics = "my-topic-01", groupId = "group-my-topic-01")
    public void topic01Consumer(ConsumerRecord<String, String> record){
        log.info("topic01Consumer - " + record.value());
    }

    // topic2는 파티션 2개이므로 같은 그룹Id 안에 다른 이름으로 두개 생성
    @KafkaListener(topics = "my-topic-02", groupId = "group-my-topic-02")
    public void topic02Consumer1(ConsumerRecord<String, String> record){
        log.info("topic02Consumer1 - " + record.value());
    }

    @KafkaListener(topics = "my-topic-02", groupId = "group-my-topic-02")
    public void topic02Consumer2(ConsumerRecord<String, String> record){
        log.info("topic02Consumer2 - " + record.value());
    }

    // topic3
    @KafkaListener(topics = "my-topic-03", groupId = "group-my-topic-03")
    public void topic03Consumer1(ConsumerRecord<String, String> record){
        log.info("topic03Consumer1 - " + record.value());
    }

    @KafkaListener(topics = "my-topic-03", groupId = "group-my-topic-03")
    public void topic03Consumer2(ConsumerRecord<String, String> record){
        log.info("topic03Consumer2 - " + record.value());
    }


    @KafkaListener(topics = "my-topic03", groupId = "group-my-topic-03")
    public void topic03Consumer3(ConsumerRecord<String, String> record){
        log.info("topic03Consumer3 - " + record.value());
    }



}















