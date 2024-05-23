package com.proyecto.productos.controladores;

import com.proyecto.productos.entidades.Producto;
import com.proyecto.productos.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {
@Autowired
ProductoRepository productoRepository;

    /////////////// CREACIÓN DE SERVICIOS /////////////

    ///// GET
    @GetMapping("/productos")
    public List<Producto> productos (){
        return productoRepository.findAll();
    }

    @GetMapping("/productos/{id}")
    public Optional<Producto> productofindId (@PathVariable int id){
        return productoRepository.findById(id);
    }


    //// POST
    @PostMapping("/productos")
    public Producto crear(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    //////  DELETE
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Boolean> eliminarProducto(@PathVariable int id){
        Optional<Producto> producto = productoRepository.findById(id);
        productoRepository.delete(producto.get());
        return ResponseEntity.ok(true);
    }

    /////// PUT
    @PutMapping("/productos/{id}")
    public  ResponseEntity <Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoData){
        Optional <Producto> opcionalProducto = productoRepository.findById(id);

        Producto producto = opcionalProducto.get();
        //actualizar
        producto.setNombre( productoData.getNombre() );
        producto.setPrecio( productoData.getPrecio());
        producto.setCategoria( productoData.getCategoria());
        producto.setUrl( productoData.getUrl());

        Producto productoGuardado = productoRepository.save(producto);
        return ResponseEntity.ok(productoGuardado);

    }
    ////// DELETE ALL
    @DeleteMapping("/productos")
    public ResponseEntity<Void> eliminarTodosLosProductos() {
        productoRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }





}
