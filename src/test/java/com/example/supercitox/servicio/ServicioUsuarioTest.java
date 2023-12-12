package com.example.supercitox.servicio;

import com.example.supercitox.modelo.Usuario;
import com.example.supercitox.repositorio.RepositorioUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class ServicioUsuarioTest {

    @Mock
    private RepositorioUsuario repositorioUsuario;
    @InjectMocks
    private ServicioUsuario servicioUsuario;

    private Usuario usuario;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        usuario = new Usuario();
        usuario.setId_usuario(55);
        usuario.setNombre("Jacob");
    }

    @Test
    void mostrarUsuarios() {
        when(repositorioUsuario.findAll()).thenReturn(Arrays.asList(usuario));
        assertNotNull(servicioUsuario.MostrarUsuarios());
    }

    @Test
    void agregarUsuario() {
        when(repositorioUsuario.save(any(Usuario.class))).thenReturn(usuario);
        assertNotNull(servicioUsuario.agregarUsuario(new Usuario()));
    }

    @Test
    void borrarUsuarioPorId() {
        doNothing().when(repositorioUsuario).deleteById(anyLong());// Llamar al método que estás probando
        servicioUsuario.borrarUsuarioPorId(1L); // Supongamos que el ID es 1 en este ejemplo
    }

    @Test
    void actualizarUsuario() {
        when(repositorioUsuario.save(any(Usuario.class))).thenReturn(usuario);
        assertNotNull(servicioUsuario.ActualizarUsuario(new Usuario()));
    }
}