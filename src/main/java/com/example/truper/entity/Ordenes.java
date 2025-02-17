package com.example.truper.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dto.CrearOrden;
import dto.ProductoDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Ordenes")
@Table(name = "ordenes")
@Getter
@Setter
@Data
public class Ordenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orden_id;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursales sucursal;

    @OneToMany(mappedBy = "Ordenes", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Productos> productos;

    public Ordenes(CrearOrden data){
        this.fecha = data.fecha();
        this.total = data.total();
        this.sucursal.setNombre(data.nombreSucursal());
        List<Productos> productsList = new ArrayList<>();
        for (ProductoDto dto : data.productos()){

        }
        this.productos = productsList;
    }

}
