package com.example.swordsofthule.dto.userDTO;

import com.example.swordsofthule.entity.Hero;
import lombok.Data;

import java.util.List;

@Data
public class UserEditRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private int goldShards;
    private List<Hero> heroList;
    private final String method = "edit";
}
