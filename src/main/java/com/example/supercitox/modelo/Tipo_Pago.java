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
public class Tipo_Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tipo_pago;
    @Column
    private String tipo_pago;

    public void actualizarDetalles(Tipo_Pago tipoPago) {
        this.tipo_pago=tipoPago.getTipo_pago();
    }
}
