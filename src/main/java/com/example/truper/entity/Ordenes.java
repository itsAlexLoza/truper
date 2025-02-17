package com.example.truper.entity;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import dto.CrearOrden;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Ordenes")
@Table(name = "ordenes")
@Getter
@Setter
@Data
@NoArgsConstructor
public class Ordenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orden_id;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private Double total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sucursal_id")
    @JsonBackReference
    private Sucursales sucursal;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Productos> productos;

    public Ordenes(CrearOrden data) {
        this.fecha = data.fecha();
        this.total = data.total();
        this.sucursal = new Sucursales();
        this.sucursal.setNombre(data.nombreSucursal());
        this.productos = data.productos().stream()
                .map(dto -> {
                    Productos producto = new Productos(dto);
                    producto.setOrden(this);
                    return producto;
                })
                .collect(Collectors.toList());
    }
}
