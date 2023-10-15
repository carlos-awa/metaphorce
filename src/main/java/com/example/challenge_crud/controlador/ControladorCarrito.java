package com.example.challenge_crud.controlador;


import com.example.challenge_crud.modelo.Carrito;
import com.example.challenge_crud.servicio.ServicioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/carrito")
public class ControladorCarrito {

private final ServicioCarrito servicioCarrito;

@Autowired
    public ControladorCarrito(ServicioCarrito servicioCarrito){this.servicioCarrito = servicioCarrito;}

@GetMapping(path = "/mostrarCarrito")
public List<Carrito> MostrarCarrito(){
    return this.servicioCarrito.MostrarCarrito();
}
}
