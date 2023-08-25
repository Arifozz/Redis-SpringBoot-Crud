package com.example.redisTemplate.service;
import com.example.redisTemplate.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class UserService {
    public static final String HASH_KEY = "user";


    private final RedisTemplate template;
/*
    @Autowired
    private RedisTemplate<String, User> template;

*/

    public User enroll(User user){
        template.opsForHash().put(HASH_KEY,user.getId(),user);
        return user;
    }

    public List<Object> getAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public User findById(int id){
        return (User) template.opsForHash().get(HASH_KEY,id);
    }

/*    public List<User> findBySurname(String surname) {
        List<User> users = getAll();
        List<User> filteredUsers = new ArrayList<>();

        for(User user : users) {
            if(Objects.equals(user.getSurname(), surname)) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }*/


    public String removeUser(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "User removed";
    }


}
