package com.example.supercitox.repositorio;

import com.example.supercitox.modelo.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDetalleCarrito extends JpaRepository<DetalleCarrito,Long> {
}
