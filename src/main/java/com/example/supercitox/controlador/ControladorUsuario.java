package com.example.supercitox.controlador;

import com.example.supercitox.modelo.Usuario;
import com.example.supercitox.servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "usuarios")
public class ControladorUsuario {
    private final ServicioUsuario servicioUsuario;
    @Autowired
    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping(path = "/mostrarUsuarios")
    public List<Usuario> mostrarUsuarios(){
        return this.servicioUsuario.mostrarUsuarios();
    }

    @PostMapping(path = "/agregarUsuario")
    public ResponseEntity<Object> agregarUsuario(@RequestBody Usuario usuario){
        return this.servicioUsuario.agregarUsuario(usuario);
    }

    @PutMapping(path = "/actualizarUsuario")
    public ResponseEntity<Object> actualizarUsuario(@RequestBody Usuario usuario){
        return this.servicioUsuario.actualizarUsuario(usuario);
    }

    @DeleteMapping("/borrarUsuario/{id_usuario}")
    public ResponseEntity<Object> borrarUsuario(@PathVariable Long id_usuario) {
        return this.servicioUsuario.borrarUsuarioId(id_usuario);
    }
}
