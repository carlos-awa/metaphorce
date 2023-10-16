package com.example.challenge_crud.repositorio;

import com.example.challenge_crud.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
    void deleteById(Long id);
}
