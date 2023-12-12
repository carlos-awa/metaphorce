package com.example.supercitox.servicio;

import com.example.supercitox.modelo.Categoria;
import com.example.supercitox.modelo.Producto;
import com.example.supercitox.modelo.Usuario;
import com.example.supercitox.repositorio.RepositorioProducto;
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

class ServicioProductoTest {
    @Mock
    private RepositorioProducto repositorioProducto;
    @InjectMocks
    private ServicioProducto servicioProducto;
    private Producto producto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        producto = new Producto();
        producto.setId_producto(55);
        producto.setProducto("AA");
        producto.setUsuario(new Usuario());
        producto.setCategoria(new Categoria());
        producto.setStock(55);
        producto.setPrecio_Unitario(55);
    }

    @Test
    void mostrarProductos() {
        when(repositorioProducto.findAll()).thenReturn(Arrays.asList(producto));
        assertNotNull(servicioProducto.mostrarProductos());
    }

    @Test
    void agregarProducto() {
        when(repositorioProducto.save(any(Producto.class))).thenReturn(producto);
        assertNotNull(servicioProducto.agregarProducto(new Producto()));
    }

    @Test
    void borrarProductoPorId() {
        doNothing().when(repositorioProducto).deleteById(anyLong());
        servicioProducto.borrarProductoId(1L);
    }

    @Test
    void actualizarProducto() {
        when(repositorioProducto.save(any(Producto.class))).thenReturn(producto);
        assertNotNull(servicioProducto.agregarProducto(new Producto()));
    }
}