package com.example.truper.controller;

import com.example.truper.entity.Ordenes;
import com.example.truper.service.OrdenService;
import dto.CrearOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    private OrdenService ordenService;

    public OrdenController(OrdenService orden){

    }

    @PostMapping
    public ResponseEntity<Ordenes> crearOrden(CrearOrden data){
        return new ResponseEntity<>(this.ordenService.crearOrden(data), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordenes> consultarOrden(@PathVariable Long id){
        return new ResponseEntity<>(this.ordenService.consultarOrden(id), HttpStatus.OK);
    }
}
