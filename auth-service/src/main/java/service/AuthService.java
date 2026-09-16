package service;

import dto.request.LoginRequest;
import dto.request.RegisterRequest;
import dto.response.LoginResponse;
import mapper.AuthUserBioMapper;
import mapper.AuthUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AuthUserBioRepository;
import repository.AuthUserRepository;

@Service
public class AuthService {
    private final AuthUserRepository authUserRepository;
    private final AuthUserBioRepository authUserBioRepository;
    private final AuthUserMapper authUserMapper;
    private final AuthUserBioMapper authUserBioMapper;


    @Autowired
    public AuthService(AuthUserRepository authUserRepository, AuthUserBioRepository authUserBioRepository, AuthUserMapper authUserMapper, AuthUserBioMapper authUserBioMapper){
        this.authUserRepository = authUserRepository;
        this.authUserBioRepository = authUserBioRepository;
        this.authUserMapper = authUserMapper;
        this.authUserBioMapper = authUserBioMapper;
    }

    public void register(RegisterRequest request){
        if (authUserRepository.findByEmail(request.email()).isPresent()){
            throw new RuntimeException("Email already exists!");
        }
        if (authUserRepository.findByUsername(request.username()).isPresent()){
            throw new RuntimeException("Username already exists!");
        }

        authUserRepository.save(authUserMapper.toEntity(request));
        authUserBioRepository.save(authUserBioMapper.toEntity(request));
    }

    public LoginResponse login(LoginRequest request){
        authUserRepository.findByEmail(request.email());
    }
}
