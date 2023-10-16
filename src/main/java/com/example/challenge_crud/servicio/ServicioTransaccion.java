package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.Transaccion;
import com.example.challenge_crud.repositorio.RepositorioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioTransaccion {
    private final RepositorioTransaccion repositorioTransaccion;

    @Autowired
    public  ServicioTransaccion(RepositorioTransaccion repositorioTransaccion){ this.repositorioTransaccion = repositorioTransaccion;}
      public List<Transaccion> mostrarTransaccion(){return this.repositorioTransaccion.findAll();}


}
