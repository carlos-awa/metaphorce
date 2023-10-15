package com.example.challenge_crud.controlador;

import com.example.challenge_crud.modelo.Usuario;
import com.example.challenge_crud.servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class ControladorUsuario {
    private final ServicioUsuario servicioUsuario;
    @Autowired
    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }


    @GetMapping(path = "/mostrarUsuarios")
    public List<Usuario> MostrarUsuarios(){
        return this.servicioUsuario.MostrarUsuarios();
    }
}
