package com.example.challenge_crud.servicio;

import com.example.challenge_crud.modelo.Tipo_pago;
import com.example.challenge_crud.repositorio.RepositorioTipoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioTipoPago {
    private final RepositorioTipoPago repositorioTipoPago;

    @Autowired
     public  ServicioTipoPago(RepositorioTipoPago repositorioTipoPago){ this.repositorioTipoPago = repositorioTipoPago;}
    public List<Tipo_pago> mostrarTipoPago(){return this.repositorioTipoPago.findAll();}

    public Tipo_pago NuevoTipoPago(Tipo_pago tipo_Pago) {
        return this.repositorioTipoPago.save(tipo_Pago);
    }

    public Tipo_pago ActualizarTipoPago(Tipo_pago tipoPago) {
        return this.repositorioTipoPago.save(tipoPago);
    }

    public void BorrarTipoPago(Long idTipoPago) {
        this.repositorioTipoPago.deleteById(idTipoPago);
    }

}
