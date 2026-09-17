package com.practice.kino.service;

import com.practice.kino.dto.request.LoginRequest;
import com.practice.kino.dto.request.RefreshTokenRequest;
import com.practice.kino.dto.request.RegisterRequest;
import com.practice.kino.dto.response.JwtAuthenticationResponse;

import javax.naming.AuthenticationException;

public interface AuthUserService {
    JwtAuthenticationResponse signIn(LoginRequest request) throws AuthenticationException;
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest request) throws Exception;
    void addUser(RegisterRequest request);
}
