package com.example.demo.service;

import com.example.demo.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User create(User user);
    User update(User user);
    User findById(String id);
    Page<User> findAll(Pageable pageable);
    void deleteById(String id);
}
