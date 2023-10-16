package com.example.challenge_crud.repositorio;

import com.example.challenge_crud.modelo.Carrito;
import com.example.challenge_crud.modelo.CarritoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositorioCarrito extends JpaRepository<Carrito, CarritoId>{
}
