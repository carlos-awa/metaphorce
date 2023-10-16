package com.example.challenge_crud.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CarritoId{
    @Column(name = "id_usuario")
    private long idusuario;

    @Column(name = "idcarrito")
    private long idcarrito;

}
