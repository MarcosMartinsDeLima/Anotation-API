package com.marcos.AnotationsApi.controller;

import com.marcos.AnotationsApi.domain.user.User;


import com.marcos.AnotationsApi.domain.user.UserRepository;
import com.marcos.AnotationsApi.domain.user.UserRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity showAll(){
        var user = userRepository.findAll();
        return ResponseEntity.ok(user);
    }
    @Transactional
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody  UserRequest data){
        User newUser =  new User(data);
        userRepository.save(newUser);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }
}
