package com.example.userservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String username;

    private String userId;

    @Builder
    public Users(String email, String password, String username, String userId) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.userId = userId;
    }
}
