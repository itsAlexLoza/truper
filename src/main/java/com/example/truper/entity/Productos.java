package com.example.truper.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import dto.ProductoDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Productos")
@Table(name = "productos")
@Getter
@Setter
@Data
@NoArgsConstructor
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producto_id;
    private String codigo;
    private String descripcion;
    private Double precio;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "orden_id")
    @JsonBackReference
    private Ordenes orden;

    public Productos(ProductoDto data){
        this.codigo = data.codigo();
        this.descripcion = data.descripcion();
        this.precio = data.precio();
    }
}
