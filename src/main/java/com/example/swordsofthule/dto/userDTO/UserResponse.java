package com.example.swordsofthule.dto.userDTO;

import com.example.swordsofthule.entity.Hero;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private int goldShards;
    private List<Hero> heroList;
}
