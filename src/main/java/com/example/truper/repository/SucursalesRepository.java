package com.example.truper.repository;

import com.example.truper.entity.Sucursales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalesRepository extends JpaRepository<Sucursales, Long> {
}
