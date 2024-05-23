package com.proyecto.productos.controladores;

import com.proyecto.productos.entidades.Carrito;
import com.proyecto.productos.repositorios.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarritoController {
    @Autowired
    CarritoRepository carritoRepository;

    /////////////// CREACIÓN DE SERVICIOS /////////////

    ///// GET
    @GetMapping("/carrito")
    public List<Carrito> carrito (){
        return carritoRepository.findAll();
    }

    @GetMapping("/carrito/{id}")
    public Optional<Carrito> carritofindId (@PathVariable int id){
        return carritoRepository.findById(id);
    }


    //// POST
    @PostMapping("/carrito")
    public Carrito crear(@RequestBody Carrito carrito){
        return carritoRepository.save(carrito);
    }

    //////  DELETE
    @DeleteMapping("/carrito/{id}")
    public ResponseEntity<Boolean> eliminarCarrito(@PathVariable int id){
        Optional<Carrito> carrito = carritoRepository.findById(id);
        carritoRepository.delete(carrito.get());
        return ResponseEntity.ok(true);
    }

    /////// PUT
    @PutMapping("/carrito/{id}")
    public  ResponseEntity <Carrito> actualizarCarrito(@PathVariable int id, @RequestBody Carrito carritoData){
        Optional <Carrito> opcionalCarrito = carritoRepository.findById(id);

        Carrito carrito = opcionalCarrito.get();
        //actualizar
        carrito.setNombre( carritoData.getNombre() );
        carrito.setPrecio( carritoData.getPrecio());
        carrito.setCategoria( carritoData.getCategoria());
        carrito.setUrl( carritoData.getUrl());
        carrito.setCantidad( carritoData.getCantidad());

        Carrito carritoGuardado = carritoRepository.save(carrito);
        return ResponseEntity.ok(carritoGuardado);

    }
    ////// DELETE ALL
    @DeleteMapping("/carrito")
    public ResponseEntity<Void> eliminarTodosLosProductos() {
        carritoRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
