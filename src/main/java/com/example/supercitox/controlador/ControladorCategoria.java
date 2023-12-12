package com.example.supercitox.controlador;

import com.example.supercitox.modelo.Categoria;
import com.example.supercitox.servicio.ServicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="categoria")
public class ControladorCategoria {
    private final ServicioCategoria servicioCategoria;

    @Autowired
    public ControladorCategoria(ServicioCategoria servicioCategoria) {
        this.servicioCategoria = servicioCategoria;
    }

    @GetMapping(path = "/mostrarCategorias")
    public List<Categoria> mostrarCategorias() {
        return this.servicioCategoria.MostrarCategorias();
    }

    @PostMapping(path = "/agregarCategoria")
    public ResponseEntity<Object> agregarCategoria(@RequestBody Categoria categoria){
        return this.servicioCategoria.agregarCategoria(categoria);
    }

    @PutMapping(path = "/actualizarCategoria")
    public ResponseEntity<Object> actualizarUsuario(@RequestBody Categoria categoria){
        return this.servicioCategoria.actualizarCategoria(categoria);
    }

    @DeleteMapping("/borrarCategoria/{id_categoria}")
    public ResponseEntity<Object> borrarUsuario(@PathVariable Long id_categoria) {
        return this.servicioCategoria.borrarCategoriaId(id_categoria);
    }
}
