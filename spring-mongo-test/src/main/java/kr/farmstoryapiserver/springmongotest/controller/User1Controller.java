package kr.farmstoryapiserver.springmongotest.controller;


import kr.farmstoryapiserver.springmongotest.document.User1Document;
import kr.farmstoryapiserver.springmongotest.service.User1Service;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class User1Controller {

    private final User1Service user1Service;

    @GetMapping("/user1")
    public List<User1Document> findUser1All(){
        return user1Service.findUser1All();
    }

    @GetMapping("/user1/{uid}")
    public User1Document findUser1(@PathVariable("uid") String uid) {
        User1Document user = user1Service.findUser1(uid).get();
        return user;
    }

    @PostMapping("/user1")
    public User1Document insertUser1(User1Document user) {
        return user1Service.insertUser1(user);
    }

    @PutMapping("/user1")
    public User1Document updateUser1(User1Document user){
        return user1Service.updateUser1(user);
    }

    @DeleteMapping("/user1/{uid}")
    public void deleteUser1(String uid) {
        user1Service.deleteUser1(uid);
    }

}















