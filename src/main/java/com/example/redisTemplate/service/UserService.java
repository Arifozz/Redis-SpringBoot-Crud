package com.example.redisTemplate.service;
import com.example.redisTemplate.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    public static final String HASH_KEY = "user";


    private final RedisTemplate template;

    @Autowired
    public UserService(RedisTemplate template) {
        this.template = template;
    }

    public User save(User user){
        template.opsForHash().put(HASH_KEY,user.getId(),user);
        return user;
    }

    public List<Object> getAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public User findById(int id){
        return (User) template.opsForHash().get(HASH_KEY,id);
    }

    public String removeUser(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "User removed";
    }


}
