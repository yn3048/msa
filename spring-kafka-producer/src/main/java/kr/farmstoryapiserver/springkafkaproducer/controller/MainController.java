package kr.farmstoryapiserver.springkafkaproducer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
public class MainController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/publish/topic01")
    public String publish1(){

        for(int i=1; i<=1000000; i++){
            // my-topic-01로 메세지 100만번 보내기
            kafkaTemplate.send("my-topic-01", "message_"+i);
        }

        return "success";
    }

    @GetMapping("/publish/topic02")
    public String publish2(){

        for(int i=1; i<=1000000; i++){
            kafkaTemplate.send("my-topic-02", "message_"+i);
        }


        return "success";
    }

    @GetMapping("/publish/topic03")
    public String publish3(){
        for(int i=1; i<=1000000; i++){
            kafkaTemplate.send("my-topic-03", "message_"+i);
        }

        return "success";
    }

}





