package com.example.userservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class RequestUser {

    @NotNull
    private String username;

    @NotNull
    @Length(min = 1, max = 30)
    private String email;

    @NotNull
    @Length(min = 4, max = 30)
    private String password;

}
