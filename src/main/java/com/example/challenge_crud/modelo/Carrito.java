package com.example.challenge_crud.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Setter
@Getter
@Table(name = "carrito")

public class Carrito {
@EmbeddedId
    private CarritoId id;


    @ManyToOne
    @MapsId("idusuario")
    @JoinColumn(name = "idusuario", insertable = false, updatable = false)
    private Usuario usuario;
    // Otros campos y relaciones

}

