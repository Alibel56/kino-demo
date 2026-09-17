package com.practice.kino.service.impl;

import com.practice.kino.dto.request.LoginRequest;
import com.practice.kino.dto.request.RefreshTokenRequest;
import com.practice.kino.dto.request.RegisterRequest;
import com.practice.kino.dto.response.JwtAuthenticationResponse;
import com.practice.kino.entity.AuthUser;
import com.practice.kino.entity.AuthUserBio;
import com.practice.kino.entity.Role;
import com.practice.kino.security.jwt.JwtService;
import com.practice.kino.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import com.practice.kino.mapper.AuthUserBioMapper;
import com.practice.kino.mapper.AuthUserMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.practice.kino.repository.AuthUserBioRepository;
import com.practice.kino.repository.AuthUserRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthUserService {
    private final AuthUserRepository authUserRepository;
    private final AuthUserBioRepository authUserBioRepository;
    private final AuthUserMapper authUserMapper;
    private final AuthUserBioMapper authUserBioMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public JwtAuthenticationResponse signIn(LoginRequest request) throws AuthenticationException {
        AuthUser user = findByCredentials(request);
        return jwtService.generateAuthToken(user.getUsername());
    }

    @Override
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest request) throws Exception {
        String refreshToken = request.refreshToken();
        if (refreshToken != null && jwtService.validateJwtToken(refreshToken)) {
            AuthUser user = findByUserName(jwtService.getUsernameFromToken(refreshToken));
            return jwtService.refreshBaseToken(user.getUsername(),  refreshToken);
        }
        throw new AuthenticationException("Invalid refresh token");
    }

    @Transactional
    public void addUser(RegisterRequest request) {
        AuthUser authUser = authUserMapper.toEntity(request);
        AuthUserBio authUserBio = authUserBioMapper.toEntity(request);

        authUser.setRole(Role.USER);
        authUser.setPassword_hashed(
                passwordEncoder.encode(request.password())
        );

        authUserBio.setAuthUser(authUser);
        authUser.setBio(authUserBio);

        authUserRepository.save(authUser);
    }

    private AuthUser findByCredentials(LoginRequest request) throws AuthenticationException {
        Optional<AuthUser> optionalAuthUser = authUserRepository.findByEmail(request.email());
        if (optionalAuthUser.isPresent()){
            AuthUser authUser = optionalAuthUser.get();
            if (passwordEncoder.matches(request.password(), authUser.getPassword_hashed())){
                return authUser;
            }
        }
        throw new AuthenticationException("Email or Password is not correct!");
    }

    private AuthUser findByUserName(String userName) throws Exception{
        return authUserRepository.findByUsername(userName)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
