package com.example.demo.service.userserviceimpl;

import com.example.demo.service.ApplicationUserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDaoImpl implements UserDetailsService {
    private final ApplicationUserDao applicationUserDao;//constructor

    public ApplicationUserDaoImpl(ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDao
                .selectUserByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("username %s not found",username)));
    }
}
