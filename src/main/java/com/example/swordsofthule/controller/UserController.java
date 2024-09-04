package com.example.swordsofthule.controller;

import com.example.swordsofthule.dto.userDTO.UserCreateRequest;
import com.example.swordsofthule.dto.userDTO.UserDeleteResponse;
import com.example.swordsofthule.dto.userDTO.UserEditRequest;
import com.example.swordsofthule.dto.userDTO.UserResponse;
import com.example.swordsofthule.entity.User;
import com.example.swordsofthule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.findAll().stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        Optional<User> user=userService.findById(id);
        return user.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserCreateRequest userCreateReq){
        User user = convertToEntity(userCreateReq);
        User savedUser = userService.save(user);
        return convertToDTO(savedUser);
    }

    @PutMapping ("/{id}")
    public UserResponse editUser(@RequestBody UserEditRequest userEditReq, @PathVariable Long id){
        User user = convertToEntity(userEditReq);
        user.setId(id);
        User savedUser = userService.save(user);
        return convertToDTO(savedUser);
    }

    @DeleteMapping ("/{id}")
    public UserDeleteResponse deleteUser (@PathVariable Long id){
        userService.deleteById(id);
        UserDeleteResponse response = new UserDeleteResponse();
        response.setId(id);
        response.setMessage("User eliminato");
        return response;
    }

    private UserResponse convertToDTO(User user){
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUserName(user.getUserName());
        dto.setHeroList(user.getHeroList());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setGoldShards(user.getGoldShards());
        return dto;
    }

    private User convertToEntity(UserCreateRequest dto){
        return new User(dto.getFirstName(),
                dto.getLastName(),
                dto.getUserName(),
                dto.getPassword(),
                dto.getEmail(),
                dto.getGoldShards(),
                dto.getHeroList());
    }

    private User convertToEntity(UserEditRequest dto){
        return new User(dto.getFirstName(),
                dto.getLastName(),
                dto.getUserName(),
                dto.getPassword(),
                dto.getEmail(),
                dto.getGoldShards(),
                dto.getHeroList());
    }
}
