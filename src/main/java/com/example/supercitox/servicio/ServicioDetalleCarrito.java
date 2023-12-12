package com.example.supercitox.servicio;

import com.example.supercitox.modelo.DetalleCarrito;
import com.example.supercitox.repositorio.RepositorioDetalleCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public List<DetalleCarrito> mostrarDetalleCarrito(){
        return this.repositorioDetalleCarrito.findAll();
    }

    public ResponseEntity<Object> agregarDetalleCarrito(DetalleCarrito detalleCarrito) {
        Optional<DetalleCarrito> res = repositorioDetalleCarrito.findById(detalleCarrito.getId());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("WARNING", detalleCarrito);
            datos.put("MESSAGE", "DetalleCarrito ya existente");
        }else{
            datos.put("SUCCESFUL", detalleCarrito);
            datos.put("MESSAGE", "detalleCarrito agregado");
            this.repositorioDetalleCarrito.save(detalleCarrito);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> actualizarDetalleCarrito(DetalleCarrito detalleCarrito) {
        Optional<DetalleCarrito> res = repositorioDetalleCarrito.findById(detalleCarrito.getId());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL", detalleCarrito);
            datos.put("MESSAGE", "DetalleCarrito actualizado con exito");
            DetalleCarrito aux = detalleCarrito;
            aux.actualizarDetalles(detalleCarrito);
            this.repositorioDetalleCarrito.save(aux);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> borrarDetalleCarritoId(Long id) {
        Optional<DetalleCarrito> res = repositorioDetalleCarrito.findById(id);

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL",null);
            datos.put("MESSAGE", "Detalle carrito borrado exitosamente");
            this.repositorioDetalleCarrito.deleteById(id);
        }else{
            datos.put("SORRY",id);
            datos.put("MESSAGE", "Detalle Carrito inexistente");
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
}
