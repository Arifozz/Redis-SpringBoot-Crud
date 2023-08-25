/*
package com.example.redisTemplate.repo;
import com.example.redisTemplate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class AppRepo {
    public static final String HASH_KEY = "user";

    @Autowired
    private RedisTemplate template;

    public User enroll(User user){
        template.opsForHash().put(HASH_KEY,user.getId(),user);
        return user;
    }

    public List<User> getAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public User findById(int id){
        return (User) template.opsForHash().get(HASH_KEY,id);
    }

    public List<User> findBySurname(String surname) {
        List<User> users = getAll();
        List<User> filteredUsers = new ArrayList<>();

        for(User user : users) {
            if(Objects.equals(user.getSurname(), surname)) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }

    public String removeUser(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "User removed";
    }





}
*/
