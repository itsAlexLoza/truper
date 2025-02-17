package com.example.truper.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name ="Sucursales")
@Table(name = "sucursales")
@Getter
@Setter
@Data
public class Sucursales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sucursal_id;
    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    List<Ordenes> ordenes;

}
