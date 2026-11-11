package com.practice.kino.repository;

import com.practice.kino.entity.UserGenrePreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface UserGenrePreferenceRepository extends JpaRepository<UserGenrePreference, UUID> {
}
