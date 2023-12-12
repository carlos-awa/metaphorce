package com.example.supercitox.servicio;

import com.example.supercitox.modelo.Opinion;
import com.example.supercitox.repositorio.RepositorioOpinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioOpinion {
    private final RepositorioOpinion repositorioOpinion;
    @Autowired
    public ServicioOpinion(RepositorioOpinion repositorioOpinion) {
        this.repositorioOpinion = repositorioOpinion;
    }

    public List<Opinion> mostrarOpiniones(){
        return this.repositorioOpinion.findAll();
    }

    public ResponseEntity<Object> agregarOpinion(Opinion opinion) {
        Optional<Opinion> res = repositorioOpinion.findById(opinion.getId());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("WARNING", opinion);
            datos.put("MESSAGE", "Opinion ya existente");
        }else{
            datos.put("SUCCESFUL", opinion);
            datos.put("MESSAGE", "Opinion agregado");
            this.repositorioOpinion.save(opinion);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> actualizarOpinion(Opinion opinion) {
        Optional<Opinion> res = repositorioOpinion.findById(opinion.getId());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("WARNING", opinion);
            datos.put("MESSAGE", "Opinion ya existente");
            Opinion aux = opinion;
            aux.actualizarDetalles(opinion);
            this.repositorioOpinion.save(opinion);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> borrarOpinionId(Long id) {
        Optional<Opinion> res = repositorioOpinion.findById(id);

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL",null);
            datos.put("MESSAGE", "Opinion borrado exitosamente");
            this.repositorioOpinion.deleteById(id);
        }else{
            datos.put("SORRY",id);
            datos.put("MESSAGE", "Opinion inexistente");
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
}
