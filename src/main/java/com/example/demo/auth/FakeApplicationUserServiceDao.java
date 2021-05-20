package com.example.demo.auth;


import com.example.demo.service.ApplicationUserDao;

import java.util.Optional;

public class FakeApplicationUserServiceDao implements ApplicationUserDao{
    @Override
    public Optional<ApplicationUser> selectUserByUserName(String username) {
        return null;
    }
}
