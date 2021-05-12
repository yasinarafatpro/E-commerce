package com.example.demo.service.userserviceimpl;

import com.example.demo.entity.user.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id)
        .orElseThrow(()->new EntityNotFoundException("user not found by email"));
    }

    @Override
    public Page<User> findAll(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);

    }
}
