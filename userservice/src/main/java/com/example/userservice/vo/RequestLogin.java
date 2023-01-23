package com.example.userservice.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestLogin {

    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "Email cannot be null")
    private String password;

}
