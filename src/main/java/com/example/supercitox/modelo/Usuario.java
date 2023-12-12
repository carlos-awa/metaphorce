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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    @Column
    private String nombre;
    @Column
    private String email;
    @Column
    private String password;

    //Copia los campos relevantes del usuario actualizado al usuario existente.
    public void actualizarDetalles(Usuario usuario) {
        this.nombre=usuario.getNombre();
        this.email=usuario.getEmail();
        this.password=usuario.getPassword();
    }
}
