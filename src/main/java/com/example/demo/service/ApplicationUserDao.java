package com.example.demo.service;


import com.example.demo.auth.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser>selectUserByUserName(String username);
}
