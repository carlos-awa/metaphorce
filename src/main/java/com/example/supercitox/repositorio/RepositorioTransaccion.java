package com.example.supercitox.repositorio;

import com.example.supercitox.modelo.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTransaccion extends JpaRepository<Transaccion,Long> {
}
