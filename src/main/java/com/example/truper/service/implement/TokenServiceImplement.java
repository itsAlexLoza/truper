package com.example.truper.service.implement;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.truper.entity.Usuarios;
import com.example.truper.service.TokenService;

@Service
public class TokenServiceImplement implements TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    @Override
    public String generarToken(Usuarios user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("sa")
                    .withSubject(user.getNombre())
                    .withClaim("id", user.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    @Override
    public String getSubject(String token) {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("El token es nulo o está vacío.");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // validando firma
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("sa")
                    .build()
                    .verify(token);
            String subject = verifier.getSubject();
            if (subject == null || subject.isBlank()) {
                throw new IllegalStateException("El token no contiene un sujeto válido.");
            }
            return subject;
        } catch (JWTVerificationException exception) {
            throw new IllegalArgumentException("El token no es válido.", exception);
        }
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(200).toInstant(ZoneOffset.of("-05:00"));
    }
}
