package com.example.supercitox.repositorio;

import com.example.supercitox.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long>{
    @Query("SELECT p.producto FROM Producto p WHERE p.producto = ?1")
    Optional<Producto> findProductoByName(String aux);//Esto ya incluye una consulta para encontrar dichoso usuario
}
