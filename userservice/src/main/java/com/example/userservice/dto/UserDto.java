package com.example.userservice.dto;

import com.example.userservice.domain.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private String username;
    private String email;
    private String userId;

    @Builder
    public UserDto(String username, String email, String userId) {
        this.username = username;
        this.email = email;
        this.userId = userId;
    }

    public UserDto(Users users) {
        this.username = users.getUsername();
        this.email = users.getEmail();
        this.userId = users.getUserId();
    }
}
