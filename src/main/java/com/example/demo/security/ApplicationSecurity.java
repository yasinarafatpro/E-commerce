package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.example.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
         //       .antMatchers("/api/**").hasRole(CUSTOMER.name())
         //       .antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
         //       .antMatchers(HttpMethod.POST,"/api/**").hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
         //       .antMatchers(HttpMethod.PUT,"/api/**").hasAuthority(ApplicationUserPermission.CUSTOMER_WRITE.getPermission())
         //       .antMatchers(HttpMethod.GET,"/api/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/products",true)
                    .passwordParameter("password")
                    .usernameParameter("username")
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(30))
                    .key("somethingverysecure")
                    .rememberMeParameter("remember-me")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID","remember_me")
                .logoutSuccessUrl("/login");
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
                .authorities(ADMINTRAINEE.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(
                rofiqUser,
                arafatUser,
                yasinUser
        );
    }
}

