package com.example.truper.service.implement;

import com.example.truper.entity.Ordenes;
import com.example.truper.entity.Sucursales;
import com.example.truper.repository.OrdenesRepository;
import com.example.truper.repository.SucursalesRepository;
import com.example.truper.service.OrdenService;
import dto.CrearOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdenServiceImplement implements OrdenService {
    @Autowired
    private OrdenesRepository ordenesRepository;

    @Autowired
    private SucursalesRepository sucursalesRepository;

    @Override
    public Ordenes crearOrden(CrearOrden data) {

        return null;
    }

    @Override
    public Ordenes consultarOrden(Long id) {
        return null;
    }
}
