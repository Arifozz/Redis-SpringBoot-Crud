package com.example.redisTemplate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("user")

public class User implements Serializable {


    @Id
    private int id;
    private String name;
    private String surname;

}
