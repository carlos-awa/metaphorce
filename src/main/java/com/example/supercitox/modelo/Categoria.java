package com.example.supercitox.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity // Esta anotación indica que esta clase es una entidad JPA y debe ser mapeada a una tabla en la base de datos.
@Table // Esta anotación se utiliza para personalizar la configuración de la tabla en la base de datos.

@Data // Lombok: Genera automáticamente los métodos getter, setter, toString, equals y hashCode.
@Getter // Lombok: Genera automáticamente el método getter.
@Setter // Lombok: Genera automáticamente el método setter.

public class Categoria {
    @Id // Esta anotación marca el campo como clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se utiliza para generar automáticamente valores de clave primaria (autoincremental).
    private long id_categoria; // Campo de clave primaria.
    @Column
    private String categoria; // Otro campo de la entidad.

    public void actualizarDetalles(Categoria categoria) {
        this.categoria=categoria.getCategoria();
    }
}
