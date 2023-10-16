package com.example.challenge_crud.repositorio;

import com.example.challenge_crud.modelo.Tipo_pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoPago extends JpaRepository<Tipo_pago, Long> {
}
