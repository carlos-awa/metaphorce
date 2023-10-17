package com.example.challenge_crud.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_carrito")

@Data
@Getter
@Setter
public class DetalleCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Carrito.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;

    @ManyToOne(targetEntity = Producto.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private float descuento;
    private int cantidad;
}
