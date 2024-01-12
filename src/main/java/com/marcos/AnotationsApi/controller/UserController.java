package com.marcos.AnotationsApi.controller;

import com.marcos.AnotationsApi.domain.user.User;



import com.marcos.AnotationsApi.domain.user.UserRepository;
import com.marcos.AnotationsApi.domain.user.UserRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity showById(@PathVariable int id){
        var user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(user);
    }

    @Transactional
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody @Valid   UserRequest data){
        User newUser =  new User(data);
        userRepository.save(newUser);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    @Transactional
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id,@RequestBody @Valid UserRequest data){
        User userTobeUpdate = userRepository.getReferenceById(id);
        userTobeUpdate.setNome(data.nome());
        userTobeUpdate.setSenha(data.senha());
        userTobeUpdate.setEmail(data.email());
        userTobeUpdate.setApelido(data.apelido());
        return ResponseEntity.ok("Usuario atualizado com sucesso!");
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
        return ResponseEntity.ok("Usuario deletado com sucessp!") ;
    }


}
