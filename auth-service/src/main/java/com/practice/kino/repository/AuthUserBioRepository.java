package com.practice.kino.repository;

import com.practice.kino.entity.AuthUserBio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserBioRepository extends JpaRepository<AuthUserBio,Long> {
}
