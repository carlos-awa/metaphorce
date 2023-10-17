package com.example.challenge_crud.repositorio;

import com.example.challenge_crud.modelo.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDetalleCarrito extends JpaRepository<DetalleCarrito,Long> {
}
