package com.example.loginback.Security.Authlogin.Jwt;

import com.example.loginback.Security.Entity.Rol;

import com.example.loginback.Security.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String getToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("firstName", user.getFirstname());
        claims.put("lastName", user.getLastname());
        List<String> roles = user.getRol().stream()
                .map(role -> role.getNombre())
                .collect(Collectors.toList());
        claims.put("roles", roles);
        return getToken(claims, user.getUsername());
    }

    private String getToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims) // Agregar las reclamaciones al token
                .setSubject(subject) // Nombre de usuario como sujeto
                .setIssuedAt(new Date(System.currentTimeMillis())) // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // Expira en 24 horas
                .signWith(getKey()) // Firmar con la clave secreta
                .compact(); // Compactar el token para devolverlo
    }


    // Método para obtener la clave secreta
    private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY); // Decodificar la clave secreta
        return Keys.hmacShaKeyFor(keyBytes); // Crear la clave secreta
    }

    // Método para obtener el nombre de usuario del token
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject); // Obtener el sujeto del token
    }

    // Método para verificar si el token es válido
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token); // Obtener el nombre de usuario
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token); // Verificar coincidencia y expiración
    }

    // Método para obtener todas las reclamaciones del token
    private Claims getAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey()) // Verificar con la clave secreta
                .build()
                .parseSignedClaims(token)
                .getPayload(); // Obtener las reclamaciones del token
    }

    // Método para obtener una reclamación específica
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token); // Obtener todas las reclamaciones
        return claimsResolver.apply(claims); // Aplicar la función para obtener la reclamación específica
    }

    // Método para obtener la fecha de expiración del token
    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration); // Obtener la fecha de expiración
    }

    // Método para verificar si el token ha expirado
    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date()); // Comparar con la fecha actual
    }
}