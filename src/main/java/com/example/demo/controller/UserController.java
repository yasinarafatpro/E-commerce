package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.user.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.userserviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/private")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserMapper userMapper;

    @PostMapping
    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<UserDto> createUser(@RequestBody User user){
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userMapper.Map(userService.create(user)));

    }
    @PutMapping
    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        user.setUpdateDate(new Date());
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.update(user));
    }

    @GetMapping("/id/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public ResponseEntity<UserDto> findById(@PathVariable String id){
         return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userMapper.Map(userService.findById(id)));
    }
    @DeleteMapping("/id/{id}")
    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping
    @PreAuthorize("hasAuthority('customer:write')")
    public List<User> findAll(){
        return userService.findAll();
    }
}


