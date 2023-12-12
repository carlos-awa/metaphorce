package com.example.supercitox.servicio;

import com.example.supercitox.modelo.Carrito;
import com.example.supercitox.repositorio.RepositorioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCarrito {
    private final RepositorioCarrito repositorioCarrito;
    @Autowired
    public ServicioCarrito(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }

    public List<Carrito> mostrarCarritos(){
        return this.repositorioCarrito.findAll();
    }

    public ResponseEntity<Object> agregarCarrito(Carrito carrito) {
        Optional<Carrito> res = repositorioCarrito.findById(carrito.getId_carrito());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("WARNING", carrito);
            datos.put("MESSAGE", "Carrito ya existente");
        }else{
            datos.put("SUCCESFUL", carrito);
            datos.put("MESSAGE", "Carrito agregado");
            this.repositorioCarrito.save(carrito);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> borrarCarritoId(Long id_carrito) {
        Optional<Carrito> res = repositorioCarrito.findById(id_carrito);

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL",null);
            datos.put("MESSAGE", "Carrito borrado exitosamente");
            this.repositorioCarrito.deleteById(id_carrito);
        }else{
            datos.put("SORRY",id_carrito);
            datos.put("MESSAGE", "Carrito inexistente");
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
}
