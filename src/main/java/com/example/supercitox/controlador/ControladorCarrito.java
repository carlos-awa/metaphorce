package com.example.supercitox.controlador;

import com.example.supercitox.modelo.Carrito;
import com.example.supercitox.servicio.ServicioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "carrito")
public class ControladorCarrito {
    private final ServicioCarrito servicioCarrito;
    @Autowired
    public ControladorCarrito(ServicioCarrito servicioCarrito) {
        this.servicioCarrito = servicioCarrito;
    }

    @GetMapping(path = "/mostrarCarrito")
    public List<Carrito> mostrarCarritos(){
        return this.servicioCarrito.mostrarCarritos();
    }

    @PostMapping(path = "/agregarCarrito")
    public ResponseEntity<Object> agregarCarrito(@RequestBody Carrito carrito){
        return this.servicioCarrito.agregarCarrito(carrito);
    }
    @DeleteMapping("/borrarCarrito/{id_carrito}")
    public ResponseEntity<Object> borrarUsuario(@PathVariable Long id_carrito) {
        return this.servicioCarrito.borrarCarritoId(id_carrito);
    }
}
