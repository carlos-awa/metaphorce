package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.Tipo_pago;
import com.example.challenge_crud.modelo.Usuario;
import com.example.challenge_crud.repositorio.RepositorioTipoPago;
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

    private Tipo_pago tipoPago;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        tipoPago = new Tipo_pago();
        tipoPago.setId_tipo_pago(55);
        tipoPago.setTipo_pago("Prueba");
    }

    @Test
    void mostrarTipoPago() {
        when(repositorioTipoPago.findAll()).thenReturn(Arrays.asList(tipoPago));
        assertNotNull(servicioTipoPago.mostrarTipoPago());
    }

    @Test
    void nuevoTipoPago() {
        when(repositorioTipoPago.save(any(Tipo_pago.class))).thenReturn(tipoPago);
        assertNotNull(servicioTipoPago.NuevoTipoPago(new Tipo_pago()));
    }

    @Test
    void actualizarTipoPago() {
        when(repositorioTipoPago.save(any(Tipo_pago.class))).thenReturn(tipoPago);
        assertNotNull(servicioTipoPago.ActualizarTipoPago(new Tipo_pago()));
    }

    @Test
    void borrarTipoPago() {
        doNothing().when(repositorioTipoPago).deleteById(anyLong());// Llamar al método que estás probando
        servicioTipoPago.BorrarTipoPago(1L); // Supongamos que el ID es 1 en este ejemplo
    }
}