package com.example.supercitox.servicio;

import com.example.supercitox.modelo.Usuario;
import com.example.supercitox.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {
    private final RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<Usuario> mostrarUsuarios() {
        return this.repositorioUsuario.findAll();
    }

    public ResponseEntity<Object> agregarUsuario(Usuario usuario) {
        Optional<Usuario> res = repositorioUsuario.findUsuarioByName(usuario.getNombre());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("WARNING", usuario);
            datos.put("MESSAGE", "Usuario ya existente");
        }else{
            datos.put("SUCCESFUL", usuario);
            datos.put("MESSAGE", "Usuario agregado");
            this.repositorioUsuario.save(usuario);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> actualizarUsuario(Usuario usuario) {
        Optional<Usuario> res = repositorioUsuario.findUsuarioByName(usuario.getNombre());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL", usuario);
            datos.put("MESSAGE", "Usuario actualizado con exito");
            Usuario aux = usuario;
            aux.actualizarDetalles(usuario);
            this.repositorioUsuario.save(aux);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> borrarUsuarioId(Long id_usuario) {
        Optional<Usuario> res = repositorioUsuario.findById(id_usuario);

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL",null);
            datos.put("MESSAGE", "Usuario borrado exitosamente");
            this.repositorioUsuario.deleteById(id_usuario);
        }else{
            datos.put("SORRY",id_usuario);
            datos.put("MESSAGE", "Usuario inexistente");
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
}

