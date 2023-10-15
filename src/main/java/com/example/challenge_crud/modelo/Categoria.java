package com.example.challenge_crud.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table

@Data
@Getter
@Setter

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Para que sea aumentaitvo
    private long id_categoria;
    private String categoria;
}
