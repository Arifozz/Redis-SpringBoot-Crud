package com.example.redisTemplate.user;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


import java.io.Serializable;

@Data
@Getter
@Setter
@RedisHash("User")

public class User implements Serializable {


    @Id
    private int id;
    private String name;
    @Indexed
    private String surname;

}
