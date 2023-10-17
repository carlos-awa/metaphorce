package com.example.challenge_crud.controlador;

import com.example.challenge_crud.modelo.DetalleCarrito;
import com.example.challenge_crud.servicio.ServicioDetalleCarrito;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/detalleCarrito")
public class ControladorDetalleCarrito {
    private final ServicioDetalleCarrito servicioDetalleCarrito;
    @Autowired
    public ControladorDetalleCarrito(ServicioDetalleCarrito servicioDetalleCarrito) {
        this.servicioDetalleCarrito = servicioDetalleCarrito;
    }

    @GetMapping(path = "/mostrarDetallesCarritos")
    public List<DetalleCarrito> mostrarDetallesCarritos(){
        return this.servicioDetalleCarrito.mostrarDetallesCarritos();
    }
}
