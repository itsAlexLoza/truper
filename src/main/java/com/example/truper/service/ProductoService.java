package com.example.truper.service;

import com.example.truper.entity.Productos;
import dto.ProductoDto;

public interface ProductoService {

    public Productos actualizaProducto(ProductoDto data);
}
