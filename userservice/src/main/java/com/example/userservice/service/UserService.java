package com.example.userservice.service;

import com.example.userservice.domain.Users;
import com.example.userservice.dto.RequestUser;
import com.example.userservice.dto.UserDto;
import com.example.userservice.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean save(RequestUser requestUser) {
        Users findUsers = userRepository.findByEmail(requestUser.getEmail());
        if (findUsers == null) {
            userRepository.save(Users.builder()
                    .email(requestUser.getEmail())
                    .username(requestUser.getUsername())
                    .userId(UUID.randomUUID().toString().substring(0, 7))
                    .password(passwordEncoder.encode(requestUser.getPassword()))
                    .build());
            return true;
        }
        return false;
    }

    public UserDto getUserDtoByUserId(String userId) {
        Users user = userRepository.findByUserId(userId).orElseThrow(
                () -> new IllegalArgumentException("error"));

        return new UserDto(user);
    }

    public List<UserDto> getUserDtoByFindAll() {
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

}
