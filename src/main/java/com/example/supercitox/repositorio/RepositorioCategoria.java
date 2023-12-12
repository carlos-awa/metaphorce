package com.example.supercitox.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.supercitox.modelo.Categoria;

import java.util.Optional;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria,Long> {
    @Query("SELECT c.categoria FROM Categoria c WHERE c.categoria = ?1")
    Optional<Categoria> findCategoriaByName(String categoria);//Esto ya incluye una consulta para encontrar dichoso usuario
}
