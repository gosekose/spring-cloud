package com.example.userservice.controller;

import com.example.userservice.dto.RequestUser;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service")
public class UserController {

    private final UserService userService;

    @Value("${greeting.message}")
    private String message;

    @GetMapping("/health-check")
    public String status() {
        return message;
    }

    @PostMapping("/users")
    public ResponseEntity createUser (@RequestBody RequestUser requestUser) {

        if(!userService.save(requestUser)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        };

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserDtoByFindAll());
    }

}

