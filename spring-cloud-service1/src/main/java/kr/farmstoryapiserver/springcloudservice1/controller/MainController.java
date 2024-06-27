package kr.farmstoryapiserver.springcloudservice1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "service1 index";
    }

}