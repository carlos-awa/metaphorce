package com.example.challenge_crud.repositorio;

import com.example.challenge_crud.modelo.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTransaccion extends JpaRepository<Transaccion,Long> {
}
