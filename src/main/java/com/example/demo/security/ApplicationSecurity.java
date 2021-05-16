package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.example.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public ApplicationSecurity(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","Index","/csc/*","/js/*").permitAll()
         //       .antMatchers("/api/**").hasAnyRole(ADMIN.name())
                .antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
                .antMatchers(HttpMethod.POST,"/api/**").hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT,"/api/**").hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
                .antMatchers(HttpMethod.GET,"/api/**").hasAnyRole(ADMIN.name(),ADMIN_TRAINEE.name())
         //       .antMatchers("/api/**").hasAnyRole(ADMIN_TRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails rofiqUser=User.builder()
                .username("rofiq")
                .password(passwordEncoder.encode("password"))
         //       .roles(CUSTOMER.name())//static import
                .authorities(CUSTOMER.getGrantedAuthorities())
                .build();
        UserDetails arafatUser=User.builder()
                .username("arafat")
                .password(passwordEncoder.encode("password1"))
         //       .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();
        UserDetails yasinUser=User.builder()
                .username("yasin")
                .password(passwordEncoder.encode("password12"))
         //       .roles(ADMIN_TRAINEE.name())
                .authorities(ADMIN_TRAINEE.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(
                rofiqUser,
                arafatUser,
                yasinUser
        );
    }
}

