package com.example.supercitox.repositorio;

import com.example.supercitox.modelo.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioOpinion extends JpaRepository<Opinion,Long> {
}
