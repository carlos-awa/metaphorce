package com.example.challenge_crud.controlador;


import com.example.challenge_crud.modelo.Categoria;
import com.example.challenge_crud.servicio.ServicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categoria")
public class ControladorCategoria{
    private final ServicioCategoria servicioCategoria;
    @Autowired
    public ControladorCategoria(ServicioCategoria servicioCategoria) {
        this.servicioCategoria = servicioCategoria;
    }

    @GetMapping(path = "/mostrarCategoria")
    public List<Categoria> MostrarCategoria(){
        return this.servicioCategoria.MostrarCategoria();
    }

    @PostMapping(path = "/insertarCategoria")
    public Categoria InsertarCategoria(@RequestBody Categoria categoria){
        return this.servicioCategoria.InsertarCategoria(categoria);
    }

    @PutMapping(path = "/actualizarCategoria/{id_categoria}")
    public Categoria ActualizarCategoria(@PathVariable Long id_categoria, @RequestBody Categoria categoria){
        return this.servicioCategoria.ActualizarCategoria(categoria);
    }

    @DeleteMapping(path = "/borrarCategoria/{id_categoria}")
    public void BorrarCategoria(@PathVariable Long id_categoria){
        this.servicioCategoria.BorrarCategoria(id_categoria);
    }
}
