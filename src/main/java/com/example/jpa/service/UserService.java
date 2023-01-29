package com.example.jpa.service;

import com.example.jpa.domain.User;
import com.example.jpa.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void create() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10_000; i++) {
            users.add(new User("user" + i));
        }

        userRepository.saveAll(users);
    }

}
