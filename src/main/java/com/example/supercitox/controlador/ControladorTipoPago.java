package com.example.supercitox.controlador;

import com.example.supercitox.modelo.Tipo_Pago;
import com.example.supercitox.servicio.ServicioTipoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tipoPago")
public class ControladorTipoPago {
    private final ServicioTipoPago servicioTipoPago;

    @Autowired
    public ControladorTipoPago(ServicioTipoPago servicioTipoPago) {
        this.servicioTipoPago = servicioTipoPago;
    }

    @GetMapping(path = "/mostrarTipoPagos")
    public List<Tipo_Pago> mostrarTipoPagos() {
        return this.servicioTipoPago.mostrarTipoPagos();
    }
    @PostMapping(path = "/agregarTipoPagos")
    public ResponseEntity<Object> agregarTipoPagos(@RequestBody Tipo_Pago tipoPago){
        return this.servicioTipoPago.agregarTipoPago(tipoPago);
    }

    @PutMapping(path = "/actualizarTipoPagos")
    public ResponseEntity<Object> actualizarUsuario(@RequestBody Tipo_Pago tipoPago){
        return this.servicioTipoPago.actualizarTipoPago(tipoPago);
    }

    @DeleteMapping("/borrarTipoPagos/{id_tipo_pago}")
    public ResponseEntity<Object> borrarUsuario(@PathVariable Long id_tipo_pago) {
        return this.servicioTipoPago.borrarTipoPagoId(id_tipo_pago);
    }
}
