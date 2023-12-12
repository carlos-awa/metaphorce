package com.example.supercitox.servicio;


import com.example.supercitox.modelo.Tipo_Pago;
import com.example.supercitox.repositorio.RepositorioTipoPago;
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

class ServicioTipoPagoTest {
    @Mock
    private RepositorioTipoPago repositorioTipoPago;

    @InjectMocks
    private ServicioTipoPago servicioTipoPago;

    private Tipo_Pago tipoPago;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        tipoPago = new Tipo_Pago();
        tipoPago.setId_tipo_pago(55);
        tipoPago.setTipo_pago("Prueba");
    }

    @Test
    void mostrarTipoPago() {
        when(repositorioTipoPago.findAll()).thenReturn(Arrays.asList(tipoPago));
        assertNotNull(servicioTipoPago.mostrarTipoPagos());
    }

    @Test
    void nuevoTipoPago() {
        when(repositorioTipoPago.save(any(Tipo_Pago.class))).thenReturn(tipoPago);
        assertNotNull(servicioTipoPago.agregarTipoPago(new Tipo_Pago()));
    }

    @Test
    void actualizarTipoPago() {
        when(repositorioTipoPago.save(any(Tipo_Pago.class))).thenReturn(tipoPago);
        assertNotNull(servicioTipoPago.actualizarTipoPago(new Tipo_Pago()));
    }

    @Test
    void borrarTipoPago() {
        doNothing().when(repositorioTipoPago).deleteById(anyLong());// Llamar al método que estás probando
        servicioTipoPago.borrarTipoPagoId(1L); // Supongamos que el ID es 1 en este ejemplo
    }
}