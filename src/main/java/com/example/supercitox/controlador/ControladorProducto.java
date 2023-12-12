package com.example.supercitox.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.supercitox.modelo.Producto;
import com.example.supercitox.servicio.ServicioProducto;

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

    @PostMapping(path = "/agregarProducto")
    public ResponseEntity<Object> agregarProducto(@RequestBody Producto producto){
        return this.servicioProducto.agregarProducto(producto);
    }

    @PutMapping(path = "/actualizarProducto")
    public ResponseEntity<Object> actualizarProducto(@RequestBody Producto producto){
        return this.servicioProducto.actualizarProdcuto(producto);
    }

    @DeleteMapping("/borrarProducto/{id_producto}")
    public ResponseEntity<Object> borrarProducto(@PathVariable Long id_producto) {
        return this.servicioProducto.borrarProductoId(id_producto);
    }
}
