package com.example.supercitox.controlador;

import com.example.supercitox.modelo.DetalleCarrito;
import com.example.supercitox.servicio.ServicioDetalleCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "detallecarrito")
public class ControladorDetalleCarrito {
    private final ServicioDetalleCarrito servicioDetalleCarrito;
    @Autowired
    public ControladorDetalleCarrito(ServicioDetalleCarrito servicioDetalleCarrito) {
        this.servicioDetalleCarrito = servicioDetalleCarrito;
    }

    @GetMapping(path = "/mostrarDetalleCarrito")
    public List<DetalleCarrito> mostrarDetalleCarrito(){
        return this.servicioDetalleCarrito.mostrarDetalleCarrito();
    }

    @PostMapping(path = "/agregarDetalleCarrito")
    public ResponseEntity<Object> agregarDetalleCarrito(@RequestBody DetalleCarrito detalleCarrito){
        return this.servicioDetalleCarrito.agregarDetalleCarrito(detalleCarrito);
    }

    @PutMapping(path = "/actualizarDetalleCarrito")
    public ResponseEntity<Object> actualizarDetalleCarrito(@RequestBody DetalleCarrito detalleCarrito){
        return this.servicioDetalleCarrito.actualizarDetalleCarrito(detalleCarrito);
    }

    @DeleteMapping("/borrarDetalleCarrito/{id}")
    public ResponseEntity<Object> borrarDetalleCarrito(@PathVariable Long id) {
        return this.servicioDetalleCarrito.borrarDetalleCarritoId(id);
    }
}
