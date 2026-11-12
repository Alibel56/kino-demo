package com.practice.kino.service.impl;

import com.practice.kino.controller.UserClient;
import com.practice.kino.dto.request.CreateUserRequest;
import com.practice.kino.dto.request.LoginRequest;
import com.practice.kino.dto.request.RefreshTokenRequest;
import com.practice.kino.dto.request.RegisterRequest;
import com.practice.kino.dto.response.JwtAuthenticationResponse;
import com.practice.kino.dto.response.RegisterResponse;
import com.practice.kino.entity.Credentials;
import com.practice.kino.entity.Role;
import com.practice.kino.repository.CredentialsRepository;
import com.practice.kino.security.jwt.JwtService;
import com.practice.kino.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthUserService {
    private final UserClient userClient;
    private final CredentialsRepository credentialsRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public JwtAuthenticationResponse signIn(LoginRequest request) throws AuthenticationException {
        Credentials credentials = findByCredentials(request);
        return jwtService.generateAuthToken(credentials.getEmail());
    }

    @Override
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest request) throws Exception {
        String refreshToken = request.refreshToken();
        if (refreshToken != null && jwtService.validateJwtToken(refreshToken)) {
            Credentials credentials = findByEmail(jwtService.getEmailFromToken(refreshToken));
            return jwtService.refreshBaseToken(credentials.getEmail(),  refreshToken);
        }
        throw new AuthenticationException("Invalid refresh token");
    }

    @Transactional
    public RegisterResponse register(RegisterRequest request) {
        if (credentialsRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already exists");
        }
        UUID userId = UUID.randomUUID();

        Credentials credentials = new Credentials();
        credentials.setUserId(userId);
        credentials.setEmail(request.email());
        credentials.setPasswordHash(
                passwordEncoder.encode(request.password())
        );
        credentials.setRole(Role.USER);
        credentialsRepository.save(credentials);

        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .id(userId)
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();

        userClient.createUser(createUserRequest);

        String token = jwtService.generateAuthToken(request.email()).token();
        return RegisterResponse.builder().userId(userId).accessToken(token).build();
    }

    private Credentials findByCredentials(LoginRequest request) throws AuthenticationException {
        Optional<Credentials> optionalCredentials = credentialsRepository.findByEmail(request.email());
        if (optionalCredentials.isPresent()){
            Credentials credentials = optionalCredentials.get();
            if (passwordEncoder.matches(request.password(), credentials.getPasswordHash())){
                return credentials;
            }
        }
        throw new AuthenticationException("Email or Password is not correct!");
    }

    private Credentials findByEmail(String email) throws Exception{
        return credentialsRepository.findByEmail(email)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}