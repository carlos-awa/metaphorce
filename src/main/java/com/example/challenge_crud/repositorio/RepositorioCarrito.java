package com.example.challenge_crud.repositorio;

import com.example.challenge_crud.modelo.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositorioCarrito extends JpaRepository<Carrito, Long>{
    void deleteById(Long id);
}
