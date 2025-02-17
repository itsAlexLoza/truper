package com.example.truper.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.truper.entity.Usuarios;
import com.example.truper.repository.UsuarioRepository;

@Configuration
public class DataLoader {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            Usuarios usuario = new Usuarios();
            usuario.setNombre("Alex Loza");
            usuario.setPassword("$2a$10$bnXQVGVcGjfAsDsQLiXjtOGhQU.6TBThwqQ0j9DThtenlIl4CWl3K");
            usuarioRepository.save(usuario);
        };
    }
}