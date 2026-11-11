package com.practice.kino.repository;

import com.practice.kino.entity.UserProfile ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
    Optional<UserProfile> findByFirstNameAndLastName(String firstName, String lastName);
}
