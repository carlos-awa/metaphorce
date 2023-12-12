package com.example.supercitox.servicio;

import com.example.supercitox.modelo.Categoria;
import com.example.supercitox.repositorio.RepositorioCategoria;
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

class ServicioCategoriaTest {
    @Mock
    private RepositorioCategoria repositorioCategoria;
    @InjectMocks
    private ServicioCategoria servicioCategoria;
    private Categoria categoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        categoria = new Categoria();
        categoria.setId_categoria(55);
        categoria.setCategoria("AA");
    }

    @Test
    void mostrarCategoria() {
        when(repositorioCategoria.findAll()).thenReturn(Arrays.asList(categoria));
        assertNotNull(servicioCategoria.MostrarCategorias());
    }

    @Test
    void insertarCategoria() {
        when(repositorioCategoria.save(any(Categoria.class))).thenReturn(categoria);
        assertNotNull(servicioCategoria.agregarCategoria(new Categoria()));
    }

    @Test
    void actualizarCategoria() {
        when(repositorioCategoria.save(any(Categoria.class))).thenReturn(categoria);
        assertNotNull(servicioCategoria.agregarCategoria(new Categoria()));
    }

    @Test
    void borrarCategoria() {
        doNothing().when(repositorioCategoria).deleteById(anyLong());// Llamar al método que estás probando
        servicioCategoria.borrarCategoriaId(1L);
    }
}