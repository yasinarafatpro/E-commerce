package com.example.demo.service;

import com.example.demo.entity.user.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    User create(User user);
    User update(User user);
    User findById(String id);
    List<User> findAll();
    void deleteById(String id);
}
