package com.example.supercitox.servicio;

import com.example.supercitox.modelo.Carrito;
import com.example.supercitox.modelo.DetalleCarrito;
import com.example.supercitox.modelo.Producto;
import com.example.supercitox.repositorio.RepositorioDetalleCarrito;
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

class ServicioDetalleCarritoTest {
    @Mock
    private RepositorioDetalleCarrito repositorioDetalleCarrito;
    @InjectMocks
    private ServicioDetalleCarrito servicioDetalleCarrito;
    private DetalleCarrito detalleCarrito;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        detalleCarrito = new DetalleCarrito();
        detalleCarrito.setId(55);
        detalleCarrito.setProducto(new Producto());
        detalleCarrito.setCarrito(new Carrito());
        detalleCarrito.setDescuento(55);
        detalleCarrito.setCantidad(55);
    }

    @Test
    void mostrarDetallesCarritos() {
        when(repositorioDetalleCarrito.findAll()).thenReturn(Arrays.asList(detalleCarrito));
        assertNotNull(servicioDetalleCarrito.mostrarDetalleCarrito());
    }

    @Test
    void nuevoDetalleCarrito() {
        when(repositorioDetalleCarrito.save(any(DetalleCarrito.class))).thenReturn(detalleCarrito);
        assertNotNull(servicioDetalleCarrito.agregarDetalleCarrito(new DetalleCarrito()));
    }

    @Test
    void actualizarDetalleCarrito() {
        when(repositorioDetalleCarrito.save(any(DetalleCarrito.class))).thenReturn(detalleCarrito);
        assertNotNull(servicioDetalleCarrito.agregarDetalleCarrito(new DetalleCarrito()));
    }

    @Test
    void borrarDetalleCarrito() {
        doNothing().when(repositorioDetalleCarrito).deleteById(anyLong());// Llamar al método que estás probando
        servicioDetalleCarrito.borrarDetalleCarritoId(1L); // Supongamos que el ID es 1 en este ejemplo
    }
}