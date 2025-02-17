package com.example.truper.service;

import com.example.truper.entity.Ordenes;
import dto.CrearOrden;

public interface OrdenService {

    public Ordenes crearOrden(CrearOrden data);
    public Ordenes consultarOrden(Long id);
}
