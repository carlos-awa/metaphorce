package com.example.challenge_crud.modelo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity // Esta anotación indica que esta clase es una entidad JPA y debe ser mapeada a una tabla en la base de datos.
@Table // Esta anotación se utiliza para personalizar la configuración de la tabla en la base de datos.

@Data // Lombok: Genera automáticamente los métodos getter, setter, toString, equals y hashCode.
@Getter // Lombok: Genera automáticamente el método getter.
@Setter // Lombok: Genera automáticamente el método setter.

public class Carrito {
    @EmbeddedId
    private CarritoId id;

    @ManyToOne // Relación many-to-one con Usuario
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    // Otros campos y relaciones
}

