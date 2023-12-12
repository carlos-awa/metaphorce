package com.example.supercitox.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.supercitox.modelo.Producto;
import com.example.supercitox.repositorio.RepositorioProducto;

@Service
public class ServicioProducto {
    private final RepositorioProducto repositorioProducto;
    @Autowired
    public ServicioProducto (RepositorioProducto repositorioProducto){
        this.repositorioProducto=repositorioProducto;
    }

    public List<Producto> mostrarProductos(){
        return this.repositorioProducto.findAll();
    }

    public ResponseEntity<Object> agregarProducto(Producto producto) {
        Optional<Producto> res = repositorioProducto.findProductoByName(producto.getProducto());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("WARNING", producto);
            datos.put("MESSAGE", "Producto ya existente");
        }else{
            datos.put("SUCCESFUL", producto);
            datos.put("MESSAGE", "Producto agregado");
            this.repositorioProducto.save(producto);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> actualizarProdcuto(Producto producto) {
        Optional<Producto> res = repositorioProducto.findProductoByName(producto.getProducto());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL", producto);
            datos.put("MESSAGE", "Producto actualizado con exito");
            Producto aux = producto;
            aux.actualizarDetalles(producto);
            this.repositorioProducto.save(aux);
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> borrarProductoId(Long idProducto) {
        Optional<Producto> res = repositorioProducto.findById(idProducto);

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("SUCCESFUL",null);
            datos.put("MESSAGE", "Producto borrado exitosamente");
            this.repositorioProducto.deleteById(idProducto);
        }else{
            datos.put("SORRY",idProducto);
            datos.put("MESSAGE", "Producto inexistente");
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
}
