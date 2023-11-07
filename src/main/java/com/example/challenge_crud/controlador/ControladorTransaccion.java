package com.example.challenge_crud.controlador;

import com.example.challenge_crud.modelo.Transaccion;
import com.example.challenge_crud.servicio.ServicioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path =  "api/v1/transaccion")
public class ControladorTransaccion {

    private  final ServicioTransaccion servicioTransaccion;

    @Autowired
    public ControladorTransaccion(ServicioTransaccion servicioTransaccion){this.servicioTransaccion = servicioTransaccion;}

    @GetMapping(path = "/mostrarTransaccion")
    public List<Transaccion> MostrarTransaccion(){ return this.servicioTransaccion.mostrarTransaccion();}
}