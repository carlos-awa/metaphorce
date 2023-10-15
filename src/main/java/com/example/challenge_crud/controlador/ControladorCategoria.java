package com.example.challenge_crud.controlador;


import com.example.challenge_crud.modelo.Categoria;
import com.example.challenge_crud.servicio.ServicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
