package com.example.challenge_crud.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table

@Data
@Setter
@Getter
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_carrito;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;
    // Otros campos y relaciones

}

