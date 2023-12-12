package com.example.supercitox.servicio;

import com.example.supercitox.modelo.DetalleCarrito;
import com.example.supercitox.modelo.Tipo_Pago;
import com.example.supercitox.modelo.Transaccion;
import com.example.supercitox.repositorio.RepositorioTransaccion;
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

class ServicioTransaccionTest {
    @Mock
    private RepositorioTransaccion repositorioTransaccion;
    @InjectMocks
    private ServicioTransaccion servicioTransaccion;
    private Transaccion transaccion;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        transaccion = new Transaccion();
        transaccion.setId_Transaccion(55);
        transaccion.setMonto(55);
        transaccion.setTitular("AA");
        transaccion.setTipoPago(new Tipo_Pago());
        transaccion.setDetalleCarrito(new DetalleCarrito());
    }

    @Test
    void mostrarTransaccion() {
        when(repositorioTransaccion.findAll()).thenReturn(Arrays.asList(transaccion));
        assertNotNull(servicioTransaccion.mostrarTransacciones());
    }

    /* Agregar en un futuro, al DEV le dio flojera
    @Test
    void insertarTransaccion() {
        when(repositorioTransaccion.save(any(Transaccion.class))).thenReturn(transaccion);
        assertNotNull(servicioTransaccion.actualizarTransaccion(new Transaccion()));
    }

    @Test
    void actualizarTransaccion() {
        when(repositorioTransaccion.save(any(Transaccion.class))).thenReturn(transaccion);
        assertNotNull(servicioTransaccion.actualizarTransaccion(new Transaccion()));
    }

    @Test
    void borrarTransaccion() {
        doNothing().when(repositorioTransaccion).deleteById(anyLong());// Llamar al método que estás probando
        servicioTransaccion.borrarTransaccion(1L); // Supongamos que el ID es 1 en este ejemplo
    }
     */
}