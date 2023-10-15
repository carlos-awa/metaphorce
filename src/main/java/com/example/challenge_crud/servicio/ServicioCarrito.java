package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.Carrito;

import com.example.challenge_crud.repositorio.RepositorioCarrito;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class ServicioCarrito {
 private final RepositorioCarrito repositorioCarrito;

 @Autowired
    public ServicioCarrito(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }

    public List<Carrito> MostrarCarrito(){return this.repositorioCarrito.findAll();}
}
