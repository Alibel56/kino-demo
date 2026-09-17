package com.practice.kino.controller;

import com.practice.kino.dto.request.LoginRequest;
import com.practice.kino.dto.request.RefreshTokenRequest;
import com.practice.kino.dto.request.RegisterRequest;
import com.practice.kino.dto.response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practice.kino.service.AuthUserService;

import javax.naming.AuthenticationException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController{

    public final AuthUserService authService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest request){
        authService.addUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody LoginRequest request){
        try {
            JwtAuthenticationResponse response = authService.signIn(request);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Authentication Failed" + e.getMessage());
        }
    }

    @PostMapping("/refresh")
    public JwtAuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest request){
        try {
            return authService.refreshToken(request);
        } catch (Exception e) {
            throw new RuntimeException("Refresh Token Failed" + e.getMessage());
        }
    }
}
