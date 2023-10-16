package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.Tipo_pago;
import com.example.challenge_crud.repositorio.RepositorioTipoPago;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServicioTipoPago {
    private final RepositorioTipoPago repositorioTipoPago;

    @Autowired
     public  ServicioTipoPago(RepositorioTipoPago repositorioTipoPago){ this.repositorioTipoPago = repositorioTipoPago;}
    public List<Tipo_pago> mostrarTipoPago(){return this.repositorioTipoPago.findAll();}

}
