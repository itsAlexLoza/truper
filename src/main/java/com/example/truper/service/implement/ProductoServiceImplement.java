package com.example.truper.service.implement;

import com.example.truper.entity.Productos;
import com.example.truper.repository.ProductosRepository;
import com.example.truper.service.ProductoService;
import dto.ProductoDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImplement implements ProductoService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public Productos actualizaProducto(ProductoDto data) {
        Optional<Productos> producto = this.productosRepository.findById(data.producto_id());
        if(producto.isPresent()){
            Productos actualizado = producto.get();
            actualizado.setDescripcion(data.descripcion());
            actualizado.setPrecio(data.precio());
            actualizado.setCodigo(data.codigo());
            return this.productosRepository.save(actualizado);
        }else{
            throw new EntityNotFoundException();
        }
    }
}
