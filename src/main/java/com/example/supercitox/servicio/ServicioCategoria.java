package com.example.supercitox.servicio;

import com.example.supercitox.modelo.Categoria;
import com.example.supercitox.repositorio.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCategoria {
    @Autowired
    private final RepositorioCategoria repositorioCategoria;

    public ServicioCategoria(RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }

    public List<Categoria> MostrarCategorias(){
        return this.repositorioCategoria.findAll();
    }

    public ResponseEntity<Object> agregarCategoria(Categoria categoria) {
        Optional<Categoria> res = repositorioCategoria.findCategoriaByName(categoria.getCategoria());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("WARNING", categoria);
            datos.put("MESSAGE", "Categoría ya existente");
        }else{
            datos.put("SUCCESFUL", categoria);
            datos.put("MESSAGE", "Categoría agregada");
            this.repositorioCategoria.save(categoria);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> actualizarCategoria(Categoria categoria) {
        Optional<Categoria> res = repositorioCategoria.findCategoriaByName(categoria.getCategoria());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL", categoria);
            datos.put("MESSAGE", "Categoria actualizada con exito");
            Categoria aux = categoria;
            aux.actualizarDetalles(categoria);
            this.repositorioCategoria.save(aux);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> borrarCategoriaId(Long id_categoria) {
        Optional<Categoria> res = repositorioCategoria.findById(id_categoria);

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL",null);
            datos.put("MESSAGE", "Categoria borrado exitosamente");
            this.repositorioCategoria.deleteById(id_categoria);
        }else{
            datos.put("SORRY",id_categoria);
            datos.put("MESSAGE", "Categoria inexistente");
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
}
