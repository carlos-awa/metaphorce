package com.example.challenge_crud.servicio;

import java.util.List;

import com.example.challenge_crud.modelo.Usuario;
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
    public Producto agregarProducto(Producto producto) {
        return repositorioProducto.save(producto);
    }

    public void borrarProductoPorId(Long id) {
        this.repositorioProducto.deleteById(id);
    }

    public Producto actualizarProducto(Producto producto) {
        return repositorioProducto.save(producto);
    }

}