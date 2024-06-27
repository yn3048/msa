package kr.farmstoryapiserver.springredistest.controller;


import kr.farmstoryapiserver.springredistest.service.RedisTemplateHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MainController {

    private final RedisTemplateHelper redisTemplateHelper;


    @PostMapping("/redis/string")
    public ResponseEntity<Object> setValue(
            @RequestParam(name="key", required = true) String key,
            @RequestParam(name="value", required = true) String value) {

        redisTemplateHelper.setValue(key, value);

        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/redis/string/{key}")
    public String getValue(@PathVariable("key") String key) {
        return redisTemplateHelper.getValue(key);
    }

    @PostMapping("/redis/list-right")
    public Long addToListFromRight(
            @RequestParam(name="key", required = true) String key,
            @RequestParam(name="value", required = true) String value) {

        return redisTemplateHelper.addToListFromRight(key, value);
    }

    @PostMapping("/redis/list-left")
    public Long addToListFromLeft(
            @RequestParam(name="key", required = true) String key,
            @RequestParam(name="value", required = true) String value) {

        return redisTemplateHelper.addToListFromLeft(key, value);
    }

    @GetMapping("/redis/list/{key}/{index}")
    public String getFromList(@PathVariable("key") String key, @PathVariable("index") int index) {
        return redisTemplateHelper.getFromList(key, index);
    }

    @GetMapping("/redis/list/{key}/{start}/{end}")
    public List<String> getRangeFromList(@PathVariable("key") String key,
                                         @PathVariable("start") int start,
                                         @PathVariable("end") int end) {

        return redisTemplateHelper.getRangeFromList(key, start, end);
    }


    @PostMapping("/redis/set")
    public Long addToSet(
            @RequestParam(name="key", required = true) String key,
            @RequestParam(name="values", required = true) String[] values) {

        return redisTemplateHelper.addToSet(key, values);
    }

    @GetMapping("/redis/set/{key}")
    public Set<String> getFromSet(@PathVariable("key") String key) {
        return redisTemplateHelper.getFromSet(key);
    }

    @PostMapping("/redis/hash")
    public ResponseEntity<Object> addToHash(
            @RequestParam(name="key", required = true) String key,
            @RequestParam(name="hashKey", required = true) String hashKey,
            @RequestParam(name="value", required = true) String value) {

        redisTemplateHelper.addToHash(key, hashKey, value);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/redis/hash/{key}/{hashKey}")
    public ResponseEntity<String> getFromHash(String key, String hashKey) {
        return ResponseEntity.ok(redisTemplateHelper.getFromHash(key, hashKey));
    }

}




























