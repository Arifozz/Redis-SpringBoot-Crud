package com.example.redisTemplate.controller;
import com.example.redisTemplate.user.User;
import com.example.redisTemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    private UserService userService;

    @PostMapping
    public User enroll(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping
    public List<Object> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Object findUserById(@PathVariable int id){
        if (userService.findById(id)==null){
            return "User NOT found!!";
        }else {
            return userService.findById(id);
        }
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id){
        if (userService.findById(id)==null){
            return "User NOT found!!";
        }
        return userService.removeUser(id);
    }
}
