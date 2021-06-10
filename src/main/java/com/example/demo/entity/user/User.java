package com.example.demo.entity.user;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.address.Address;
import com.example.demo.security.ApplicationUserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class User extends BaseEntity {

    @Column(name = "user_name",length = 50)
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_Address")
    private String address;

    @Column(name = "password",length = 50)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "user_phone_number")
    private String phoneNumber;

    @Column(name = "Enabled")
    private Boolean enabled;

}
