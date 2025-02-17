package com.example.truper.service;

import com.example.truper.entity.Usuarios;

public interface TokenService {

    public String generarToken(Usuarios user);
    public String getSubject(String token);
}
