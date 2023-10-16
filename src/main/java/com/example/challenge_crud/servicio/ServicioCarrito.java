package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.Carrito;
import com.example.challenge_crud.repositorio.RepositorioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioCarrito {
 private final RepositorioCarrito repositorioCarrito;

 @Autowired
    public ServicioCarrito(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }

    public List<Carrito> MostrarCarrito(){
     return repositorioCarrito.findAll();
 }

    public Carrito agregarCarrito(Carrito carrito) {
        return repositorioCarrito.save(carrito);
    }

    public void borrarCarritoPorId(Long id) {
        repositorioCarrito.deleteById(id);
    }
}
