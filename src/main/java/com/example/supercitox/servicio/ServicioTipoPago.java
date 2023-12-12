package com.example.supercitox.servicio;

import com.example.supercitox.modelo.Tipo_Pago;
import com.example.supercitox.repositorio.RepositorioTipoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioTipoPago {
    private final RepositorioTipoPago repositorioTipoPago;
    @Autowired
    public ServicioTipoPago(RepositorioTipoPago repositorioTipoPago) {
        this.repositorioTipoPago = repositorioTipoPago;
    }

    public List<Tipo_Pago> mostrarTipoPagos(){
        return this.repositorioTipoPago.findAll();
    }

    public ResponseEntity<Object> agregarTipoPago(Tipo_Pago tipoPago) {
        Optional<Tipo_Pago> res = repositorioTipoPago.findTipoPagoByName(tipoPago.getTipo_pago());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("WARNING", tipoPago);
            datos.put("MESSAGE", "Pago ya existente");
        }else{
            datos.put("SUCCESFUL", tipoPago);
            datos.put("MESSAGE", "Usuario agregado");
            this.repositorioTipoPago.save(tipoPago);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> actualizarTipoPago(Tipo_Pago tipoPago) {
        Optional<Tipo_Pago> res = repositorioTipoPago.findTipoPagoByName(tipoPago.getTipo_pago());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL", tipoPago);
            datos.put("MESSAGE", "Pago actualizado con exito");
            Tipo_Pago aux = tipoPago;
            aux.actualizarDetalles(tipoPago);
            this.repositorioTipoPago.save(aux);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> borrarTipoPagoId(Long id_tipo_pago) {
        Optional<Tipo_Pago> res = repositorioTipoPago.findById(id_tipo_pago);

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL",null);
            datos.put("MESSAGE", "Pago borrado exitosamente");
            this.repositorioTipoPago.deleteById(id_tipo_pago);
        }else{
            datos.put("SORRY",id_tipo_pago);
            datos.put("MESSAGE", "Pago inexistente");
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
}
