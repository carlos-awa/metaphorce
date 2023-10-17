package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.DetalleCarrito;
import com.example.challenge_crud.repositorio.RepositorioDetalleCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDetalleCarrito {
    private final RepositorioDetalleCarrito repositorioDetalleCarrito;
    @Autowired
    public ServicioDetalleCarrito(RepositorioDetalleCarrito repositorioDetalleCarrito) {
        this.repositorioDetalleCarrito = repositorioDetalleCarrito;
    }

    public List<DetalleCarrito> mostrarDetallesCarritos(){
        return this.repositorioDetalleCarrito.findAll();
    }
}
