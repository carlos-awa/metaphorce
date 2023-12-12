package com.example.supercitox.repositorio;

import com.example.supercitox.modelo.Tipo_Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioTipoPago extends JpaRepository<Tipo_Pago,Long> {
    @Query("SELECT tp.tipo_pago FROM Tipo_Pago tp WHERE tp.tipo_pago = ?1")
    Optional<Tipo_Pago> findTipoPagoByName(String aux);
}
