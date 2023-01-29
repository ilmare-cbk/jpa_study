package com.example.jpa.controller;

import com.example.jpa.domain.User;
import com.example.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> readAll() {
        return ResponseEntity.ok(userService.readAll());
    }

    @PostMapping
    public void create() {
        long start = System.currentTimeMillis();
        userService.create();
        log.info("elapsed time : {}", System.currentTimeMillis() - start);
    }
}
