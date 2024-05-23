package com.proyecto.productos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Double precio;
    private String categoria;
    private String url;
}
