package com.practice.kino.repository;

import com.practice.kino.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, UUID> {
    Optional<Credentials> findByEmail(String email);
    boolean existsByEmail(String email);
}
