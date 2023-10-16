package com.example.challenge_crud.controlador;
import com.example.challenge_crud.modelo.Carrito;

import com.example.challenge_crud.servicio.ServicioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/carritos")

public class ControladorCarrito {
    private final ServicioCarrito servicioCarrito;
@Autowired
    public ControladorCarrito(ServicioCarrito servicioCarrito) {
        this.servicioCarrito = servicioCarrito;
    }
    @GetMapping(path = "/mostrarCarrito")
    public List<Carrito> MostrarCarrito() {
        return servicioCarrito.MostrarCarrito();
    }

    @PostMapping(path = "/agregarCarrito")
    public Carrito agregarCarrito(@RequestBody Carrito carrito) {
        return servicioCarrito.agregarCarrito(carrito);
    }

    @DeleteMapping("/borrarCarrito")
    public void borrarCarrito(@PathVariable Long id) {
        servicioCarrito.borrarCarritoPorId(id);
    }

}
