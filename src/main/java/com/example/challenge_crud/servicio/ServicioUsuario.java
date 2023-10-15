package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.Usuario;
import com.example.challenge_crud.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuario {
    private final RepositorioUsuario repositorioUsuario;
    @Autowired
    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    public List<Usuario> MostrarUsuarios(){
        return this.repositorioUsuario.findAll();
    }
}
