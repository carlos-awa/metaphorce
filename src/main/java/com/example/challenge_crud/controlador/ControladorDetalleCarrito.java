package com.example.challenge_crud.controlador;

import com.example.challenge_crud.modelo.DetalleCarrito;
import com.example.challenge_crud.servicio.ServicioDetalleCarrito;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/registraDetalleCarrito")
    public DetalleCarrito InsertarDetalleCarrito(@RequestBody DetalleCarrito detalleCarrito){
        return servicioDetalleCarrito.nuevoDetalleCarrito(detalleCarrito);
    }

    @PutMapping(path = "/actualizarDetalleCarrito/{id}")
    public DetalleCarrito ActualizarDetalleCarrito(@PathVariable Long id,@RequestBody DetalleCarrito detalleCarrito){
        return servicioDetalleCarrito.ActualizarDetalleCarrito(detalleCarrito);
    }

    @DeleteMapping(path = "/borrarDetalleCarrito/{id}")
    public void BorrarDetalleCarrito(@PathVariable Long id){
        this.servicioDetalleCarrito.BorrarDetalleCarrito(id);
    }
}
