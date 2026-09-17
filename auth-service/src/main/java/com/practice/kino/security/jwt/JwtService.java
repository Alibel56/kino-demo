package com.practice.kino.security.jwt;

import com.practice.kino.dto.response.JwtAuthenticationResponse;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
@Slf4j
public class JwtService {

    @Value("CYIq6iph0nHqEFl7mOqgmFIAZThxwXYTXb0clxbMbUo")
    private String jwtSecret;


    public JwtAuthenticationResponse generateAuthToken(String username){
        return JwtAuthenticationResponse.builder()
                .token(generateJwtToken(username))
                .refreshToken(generateJwtRefreshToken(username))
                .build();
    }

    public JwtAuthenticationResponse refreshBaseToken(String username, String refreshToken){
        return JwtAuthenticationResponse.builder()
                .token(generateJwtToken(username))
                .refreshToken(refreshToken)
                .build();
    }

    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    public boolean validateJwtToken(String token){
        try{
            Jwts.parser()
                    .verifyWith(getSignKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return true;
        }catch (ExpiredJwtException e){
            log.error("Expired JwtException", e);
        }catch (UnsupportedJwtException e){
            log.error("Unsupported JwtException", e);
        }catch (MalformedJwtException e){
            log.error("Malformed JwtException", e);
        }catch (SecurityException e){
            log.error("Security Exception", e);
        }catch (Exception e){
            log.error("Invalid token", e);
        }
        return false;
    }


    private String generateJwtToken(String username) {
        Date date = Date.from(LocalDateTime.now().plusMinutes(15).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(username)
                .expiration(date)
                .signWith(getSignKey())
                .compact();
    }

    private String generateJwtRefreshToken(String username) {
        Date date = Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(username)
                .expiration(date)
                .signWith(getSignKey())
                .compact();
    }

    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
