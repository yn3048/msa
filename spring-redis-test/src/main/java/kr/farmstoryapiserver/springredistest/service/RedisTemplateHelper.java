package kr.farmstoryapiserver.springredistest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class RedisTemplateHelper {

    private final StringRedisTemplate redisTemplate;

    // String 타입 get/set
    public String getValue(String key){
        ValueOperations<String, String> valueOps =  redisTemplate.opsForValue();
        return valueOps.get(key);
    }

    public void setValue(String key, String value){
        ValueOperations<String, String> valueOps =  redisTemplate.opsForValue();
        valueOps.set(key, value);

    }

    // List 타입 get/set
    public Long addToListFromRight(String key, String value){
        ListOperations<String, String> listOps =  redisTemplate.opsForList();
        return listOps.rightPush(key, value);
    }

    public Long addToListFromLeft(String key, String value){
        ListOperations<String, String> listOps =  redisTemplate.opsForList();
        return listOps.leftPush(key, value);
    }

    public String getFromList(String key, int index){
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        return listOps.index(key,index);
    }

    public List<String> getRangeFromList(String key, int start, int end){
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        return listOps.range(key, start, end);
    }

    // Set 타입 get/set
    public Long addToSet(String key, String... values){
        SetOperations<String, String> setOps =  redisTemplate.opsForSet();
        return setOps.add(key, values);
    }

    public Set<String> getFromSet(String key){
        SetOperations<String, String> setOps =  redisTemplate.opsForSet();
        return setOps.members(key);
    }

    // Hash 타입 get/set
    public void addToHash(String key, String hashKey, String value){
         HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
         hashOps.put(key, hashKey, value);
    }

    public String getFromHash(String key, String hashKey){
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        return hashOps.get(key, hashKey);
    }




}











