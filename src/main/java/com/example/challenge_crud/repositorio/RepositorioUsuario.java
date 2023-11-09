package com.example.challenge_crud.repositorio;

import com.example.challenge_crud.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
    void deleteById(Long id);

    Optional<Usuario> findOneByEmail(String email);
}
