package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.user.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.userserviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping("/api/private")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody User user){
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userMapper.Map(userService.create(user)));

    }
    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody User user){
        user.setUpdateDate(new Date());
        return ResponseEntity.status(HttpStatus.OK)
                .body(userMapper.Map(userService.update(user)));

    }
}
