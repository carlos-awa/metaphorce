package com.example.challenge_crud.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.challenge_crud.modelo.Producto;
import com.example.challenge_crud.repositorio.RepositorioProducto;

@Service
public class ServicioProducto {
    private final RepositorioProducto repositorioProducto;
    @Autowired
    public ServicioProducto (RepositorioProducto repositorioProducto){
        this.repositorioProducto=repositorioProducto;
    }

    public List<Producto> mostrarProductos(){
        return this.repositorioProducto.findAll();
    }
}