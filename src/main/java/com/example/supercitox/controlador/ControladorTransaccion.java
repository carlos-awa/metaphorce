package com.example.supercitox.controlador;

import com.example.supercitox.modelo.Transaccion;
import com.example.supercitox.servicio.ServicioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transacciones")
public class ControladorTransaccion {
    private final ServicioTransaccion servicioTransaccion;
    @Autowired
    public ControladorTransaccion(ServicioTransaccion servicioTransaccion) {
        this.servicioTransaccion = servicioTransaccion;
    }

    @GetMapping(path = "/mostrarTransacciones")
    public List<Transaccion> mostrarTransacciones(){
        return this.servicioTransaccion.mostrarTransacciones();
    }
}
