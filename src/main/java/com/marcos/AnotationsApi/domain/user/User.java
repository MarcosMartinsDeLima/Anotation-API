package com.marcos.AnotationsApi.domain.user;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "user")
@Entity(name = "user")
@EqualsAndHashCode(of = "id_user")
@Setter
@Getter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    private  String nome;

    private  String email;

    private  String senha;

    private  String apelido;

    public User(){}
    public User (UserRequest userRequest){
        this.nome = userRequest.nome();
        this.email = userRequest.email();
        this.senha = userRequest.senha();
        this.apelido = userRequest.apelido();
    }

}
