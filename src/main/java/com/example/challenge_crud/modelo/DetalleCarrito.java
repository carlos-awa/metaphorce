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
public class DetalleCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float descuento;
    private int cantidad;

    @ManyToOne(targetEntity = Producto.class)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne(targetEntity = Carrito.class)
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;
}
