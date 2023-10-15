package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.Categoria;
import com.example.challenge_crud.repositorio.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioCategoria {
    private final RepositorioCategoria repositorioCategoria;

    @Autowired
    public ServicioCategoria (RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }
    public List<Categoria> MostrarCategoria(){
        return this.repositorioCategoria.findAll();
    }
}