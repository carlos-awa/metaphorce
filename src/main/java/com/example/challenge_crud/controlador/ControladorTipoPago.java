package com.example.challenge_crud.controlador;

import com.example.challenge_crud.modelo.Tipo_pago;
import com.example.challenge_crud.servicio.ServicioTipoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/TipoPago")
public class ControladorTipoPago {
    private final ServicioTipoPago servicioTipoPago;

    @Autowired
    public ControladorTipoPago(ServicioTipoPago servicioTipoPago){ this.servicioTipoPago = servicioTipoPago;}

    @GetMapping(path = "/mostrarTipoPago")
    public List<Tipo_pago> mostrarTipoPago(){ return this.servicioTipoPago.mostrarTipoPago();}
}
