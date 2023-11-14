package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.Carrito;
import com.example.challenge_crud.modelo.Usuario;
import com.example.challenge_crud.repositorio.RepositorioCarrito;
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

class ServicioCarritoTest {
    @Mock
    private RepositorioCarrito repositorioCarrito;
    @InjectMocks
    private ServicioCarrito servicioCarrito;
    private Carrito carrito;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        carrito = new Carrito();
        carrito.setId_carrito(55);
        carrito.setUsuario(new Usuario());
    }

    @Test
    void mostrarCarrito() {
        when(repositorioCarrito.findAll()).thenReturn(Arrays.asList(carrito));
        assertNotNull(servicioCarrito.MostrarCarrito());
    }

    @Test
    void agregarCarrito() {
        when(repositorioCarrito.save(any(Carrito.class))).thenReturn(carrito);
        assertNotNull(servicioCarrito.agregarCarrito(new Carrito()));
    }

    @Test
    void borrarCarritoPorId() {
        doNothing().when(repositorioCarrito).deleteById(anyLong());// Llamar al método que estás probando
        servicioCarrito.borrarCarritoPorId(1L);
    }

    @Test
    void actualizarCarrito() {
        when(repositorioCarrito.save(any(Carrito.class))).thenReturn(carrito);
        assertNotNull(servicioCarrito.agregarCarrito(new Carrito()));
    }
}