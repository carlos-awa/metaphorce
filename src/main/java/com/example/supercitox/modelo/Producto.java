package com.example.supercitox.modelo;

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

    //Copia los campos relevantes del usuario actualizado al usuario existente.
    public void actualizarDetalles(Producto producto) {
        this.producto=producto.getProducto();
        this.precio_Unitario=producto.getPrecio_Unitario();
        this.stock=producto.getStock();
    }
}
