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

public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Transaccion;
    private String titular;
    private float monto;

    @ManyToOne
    @JoinColumn(name = "id")
    private DetalleCarrito detalleCarrito;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago")
    private Tipo_Pago tipoPago;

    public void actualizarDetalles(Transaccion transaccion) {
        this.titular=transaccion.getTitular();
        this.monto=transaccion.getMonto();
    }
}
