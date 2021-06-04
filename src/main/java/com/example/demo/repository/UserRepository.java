package com.example.demo.repository;

import com.example.demo.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 5/11/2021.
 */
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,String> {
}
