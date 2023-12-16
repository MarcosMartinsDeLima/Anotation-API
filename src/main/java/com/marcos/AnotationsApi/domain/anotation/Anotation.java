package com.marcos.AnotationsApi.domain.anotation;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "anotation")
@Entity(name = "anotation")
@EqualsAndHashCode(of = "id_anotation")
@Getter
@Setter
public class Anotation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_anotation;

    private int id_user;

    private String anotacao;

    private int terminado;
}
