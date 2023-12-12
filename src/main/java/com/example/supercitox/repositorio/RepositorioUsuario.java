package com.example.supercitox.repositorio;

import com.example.supercitox.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
    @Query("SELECT u.nombre FROM Usuario u WHERE u.nombre = ?1")
    Optional<Usuario> findUsuarioByName(String aux);//Esto ya incluye una consulta para encontrar dichoso usuario

    Optional<Usuario> findByEmail(String email);
}
