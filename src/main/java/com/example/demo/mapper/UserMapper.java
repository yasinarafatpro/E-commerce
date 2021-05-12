package com.example.demo.mapper;


import com.example.demo.dto.UserDto;
import com.example.demo.entity.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDto Map(User user){
        UserDto dto=new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }
}
