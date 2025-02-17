package com.example.truper.controller;

import com.example.truper.entity.Productos;
import com.example.truper.service.ProductoService;
import dto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PutMapping
    public ResponseEntity<Productos> actualizarProucto(ProductoDto data){
        return new ResponseEntity<>(this.productoService.actualizaProducto(data), HttpStatus.OK);
    }
}
