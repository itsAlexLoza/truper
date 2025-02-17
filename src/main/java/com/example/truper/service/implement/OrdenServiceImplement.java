package com.example.truper.service.implement;

import com.example.truper.entity.Ordenes;
import com.example.truper.repository.OrdenesRepository;
import com.example.truper.service.OrdenService;
import dto.CrearOrden;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdenServiceImplement implements OrdenService {
    @Autowired
    private OrdenesRepository ordenesRepository;

    @Override
    public Ordenes crearOrden(CrearOrden data) {
        return this.ordenesRepository.save(new Ordenes(data));
    }

    @Override
    public Ordenes consultarOrden(Long id) {
        Optional<Ordenes> ordenOptional = this.ordenesRepository.findById(id);
        if(ordenOptional.isPresent()){
            return ordenOptional.get();
        }else{
            throw new EntityNotFoundException();
        }
    }
}
