package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.DetalleCarrito;
import com.example.challenge_crud.modelo.Usuario;
import com.example.challenge_crud.repositorio.RepositorioDetalleCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioDetalleCarrito {
    private final RepositorioDetalleCarrito repositorioDetalleCarrito;
    @Autowired
    public ServicioDetalleCarrito(RepositorioDetalleCarrito repositorioDetalleCarrito) {
        this.repositorioDetalleCarrito = repositorioDetalleCarrito;
    }

    public List<DetalleCarrito> mostrarDetallesCarritos(){
        return this.repositorioDetalleCarrito.findAll();
    }

    public DetalleCarrito nuevoDetalleCarrito(DetalleCarrito detalleCarrito ){
        return this.repositorioDetalleCarrito.save(detalleCarrito);
    }

    public DetalleCarrito ActualizarDetalleCarrito(DetalleCarrito detalleCarrito){
        return repositorioDetalleCarrito.save(detalleCarrito);
    }

    public void BorrarDetalleCarrito(Long id){
        this.repositorioDetalleCarrito.deleteById(id);
    }

}
