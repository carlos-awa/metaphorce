package com.example.challenge_crud.modelo;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CarritoId implements Serializable {
    private Long idcarrito;
    private Long id_usuario;

}
