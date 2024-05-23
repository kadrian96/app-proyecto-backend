package com.proyecto.productos.repositorios;

import com.proyecto.productos.entidades.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
}
