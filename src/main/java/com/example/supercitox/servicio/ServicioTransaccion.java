package com.example.supercitox.servicio;

import com.example.supercitox.modelo.Transaccion;
import com.example.supercitox.repositorio.RepositorioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioTransaccion {
    private final RepositorioTransaccion repositorioTransaccion;
    @Autowired
    public ServicioTransaccion(RepositorioTransaccion repositorioTransaccion) {
        this.repositorioTransaccion = repositorioTransaccion;
    }

    public List<Transaccion> mostrarTransacciones(){
        return this.repositorioTransaccion.findAll();
    }
}
