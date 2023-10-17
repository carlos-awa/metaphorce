package com.example.challenge_crud.controlador;

import com.example.challenge_crud.modelo.Tipo_pago;
import com.example.challenge_crud.servicio.ServicioTipoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tipoPago")
public class ControladorTipoPago {
    private final ServicioTipoPago servicioTipoPago;

    @Autowired
    public ControladorTipoPago(ServicioTipoPago servicioTipoPago){ this.servicioTipoPago = servicioTipoPago;}

    @GetMapping(path = "/mostrarTipoPagos")
    public List<Tipo_pago> mostrarTipoPago(){ return this.servicioTipoPago.mostrarTipoPago();}

    @PostMapping(path = "/registrarTipoPago")
    public Tipo_pago InsertarTipoPago(@RequestBody Tipo_pago tipo_Pago){
        return servicioTipoPago.NuevoTipoPago(tipo_Pago);
    }

    @PutMapping(path = "/actualizarTipoPago/{id_tipo_pago}")
    public Tipo_pago ActualizarTipoPago(@PathVariable Long id_tipo_pago, @RequestBody Tipo_pago tipo_pago){
        return servicioTipoPago.ActualizarTipoPago(tipo_pago);
    }

    @DeleteMapping(path = "/borrarTipoPago/{id_tipo_pago}")
    public void BorrarTipoPago(@PathVariable Long id_tipo_pago){
        this.servicioTipoPago.BorrarTipoPago(id_tipo_pago);
    }
}
