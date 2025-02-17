package com.example.truper.repository;

import com.example.truper.entity.Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Long> {
}
