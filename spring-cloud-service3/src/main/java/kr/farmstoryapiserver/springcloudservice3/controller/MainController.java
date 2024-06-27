package kr.farmstoryapiserver.springcloudservice3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(){

        log.info("service3 index...1");

        return "service3 index";
    }

}