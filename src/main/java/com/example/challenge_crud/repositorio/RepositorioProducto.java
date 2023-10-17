package com.example.challenge_crud.repositorio;

import com.example.challenge_crud.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long>{

}
