package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.DetalleCarrito;
import com.example.challenge_crud.modelo.Transaccion;
import com.example.challenge_crud.repositorio.RepositorioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class ServicioTransaccion {
    private final RepositorioTransaccion repositorioTransaccion;
    @Autowired
    public  ServicioTransaccion(RepositorioTransaccion repositorioTransaccion){this.repositorioTransaccion = repositorioTransaccion;}
    public List<Transaccion> mostrarTransaccion(){return this.repositorioTransaccion.findAll();}

    public Transaccion insertarTransaccion(Transaccion transaccion) {
        return this.repositorioTransaccion.save(transaccion);
    }

    public Transaccion ActualizarTransaccion(Transaccion transaccion) {
        return this.repositorioTransaccion.save(transaccion);
    }

    public void BorrarTransaccion(Long id_Transaccion) {
        this.repositorioTransaccion.deleteById(id_Transaccion);
    }

}
