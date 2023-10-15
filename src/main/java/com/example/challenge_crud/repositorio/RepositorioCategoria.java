package com.example.challenge_crud.repositorio;

import com.example.challenge_crud.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long>{
}
