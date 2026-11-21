package com.practice.kino.controller;

import com.practice.kino.dto.request.AddGenreRequest;
import com.practice.kino.entity.UserGenrePreference;
import com.practice.kino.service.UserGenrePreferenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class GenrePreferenceController {

    private final UserGenrePreferenceService userGenrePreferenceService;

    @PostMapping("/genre-preferences")
    public ResponseEntity<HttpStatus> addUserGenrePreference(
            @Valid @RequestBody AddGenreRequest request
    ){
        userGenrePreferenceService.addUserGenrePreference(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/genre-preferences/{userId}")
    public ResponseEntity<Set<UserGenrePreference>> getUserGenrePreference(
            @PathVariable UUID userId
    ){
        return ResponseEntity.ok(userGenrePreferenceService.findByUserId(userId));
    }

    @DeleteMapping("/genre-preferences/{genreId}")
    public ResponseEntity<HttpStatus> deleteUserGenrePreference(
            @PathVariable UUID genreId
    ){
        userGenrePreferenceService.deleteUserGenrePreference(genreId);
        return ResponseEntity.ok().build();
    }
}
