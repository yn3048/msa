package kr.farmstoryapiserver.springmongotest.service;

import kr.farmstoryapiserver.springmongotest.document.User1Document;
import kr.farmstoryapiserver.springmongotest.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public Optional<User1Document> findUser1(String uid){
        return user1Repository.findByUid(uid);
    }

    public List<User1Document> findUser1All(){
        return user1Repository.findAll();
    }

    public User1Document insertUser1(User1Document user){
        return user1Repository.insert(user);
    }

    public User1Document updateUser1(User1Document user){
        return user1Repository.save(user);
    }

    public Optional<User1Document> deleteUser1(String uid){
        return user1Repository.deleteByUid(uid);
    }

}
