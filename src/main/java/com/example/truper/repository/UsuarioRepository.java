package com.example.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.truper.entity.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    public UserDetails findByNombre(String userName);
}
