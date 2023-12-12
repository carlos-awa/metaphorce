package com.example.supercitox.controlador;

import com.example.supercitox.modelo.Opinion;
import com.example.supercitox.servicio.ServicioOpinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "opinion")
public class ControladorOpinion {
    private final ServicioOpinion servicioOpinion;

    @Autowired
    public ControladorOpinion(ServicioOpinion servicioOpinion) {
        this.servicioOpinion = servicioOpinion;
    }

    @GetMapping(path = "/opinion")
    public List<Opinion> mostrarOpiniones(){
        return this.servicioOpinion.mostrarOpiniones();
    }

    @PostMapping(path = "/agregarOpinion")
    public ResponseEntity<Object> agregarOpinion(@RequestBody Opinion opinion){
        return this.servicioOpinion.agregarOpinion(opinion);
    }

    @PutMapping(path = "/actualizarOpinion")
    public ResponseEntity<Object> actualizarOpinion(@RequestBody Opinion opinion){
        return this.servicioOpinion.actualizarOpinion(opinion);
    }

    @DeleteMapping("/borrarOpinion/{id}")
    public ResponseEntity<Object> borrarOpinion(@PathVariable Long id) {
        return this.servicioOpinion.borrarOpinionId(id);
    }
}
