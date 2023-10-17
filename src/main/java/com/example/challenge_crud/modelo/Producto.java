package com.example.challenge_crud.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table

@Data
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_producto;
    private String producto;
    private float precio_Unitario;
    private int stock;

    @ManyToOne
    @JoinColumn(name="id_vendedor")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
}
