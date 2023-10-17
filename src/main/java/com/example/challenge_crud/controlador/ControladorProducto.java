package com.example.challenge_crud.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.challenge_crud.modelo.Producto;
import com.example.challenge_crud.servicio.ServicioProducto;

@RestController
@RequestMapping (path = "api/v1/productos")
public class ControladorProducto {
    private final ServicioProducto servicioProducto;
    @Autowired
    public ControladorProducto(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }

    @GetMapping(path = "/mostrarProductos")
    public List<Producto> mostrarProductos(){
        return this.servicioProducto.mostrarProductos();
    }
}
