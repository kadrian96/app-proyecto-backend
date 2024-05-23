package com.proyecto.productos.repositorios;

import com.proyecto.productos.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
