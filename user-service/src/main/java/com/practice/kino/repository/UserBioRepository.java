package com.practice.kino.repository;

import com.practice.kino.entity.UserBio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserBioRepository extends JpaRepository<UserBio, UUID> {
}
