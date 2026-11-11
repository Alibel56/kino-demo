package com.practice.kino.controller;


import com.practice.kino.dto.request.AddGenreRequest;
import com.practice.kino.dto.request.CreateUserRequest;
import com.practice.kino.dto.request.UpdateBioRequest;
import com.practice.kino.dto.request.UpdateProfileRequest;
import com.practice.kino.dto.response.BioReadResponse;
import com.practice.kino.dto.response.ProfileReadResponse;
import com.practice.kino.entity.UserGenrePreference;
import com.practice.kino.service.UserBioService;
import com.practice.kino.service.UserGenrePreferenceService;
import com.practice.kino.service.UserProfileService;
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
public class UserController {

    private final UserProfileService userService;
    private final UserBioService userBioService;
    private final UserGenrePreferenceService userGenrePreferenceService;

    @PostMapping("/profile")
    public ResponseEntity<ProfileReadResponse> createUser(
            @Valid @RequestBody CreateUserRequest request) {

        return ResponseEntity.ok(userService.createUserProfile(request));
    }

    @PatchMapping("/profile/{userId}")
    public ResponseEntity<HttpStatus> updateUserProfile(
            @PathVariable(name = "userId") UUID id,
            @Valid @RequestBody UpdateProfileRequest request){

        userService.updateUserProfile(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/profile/{userId}")
    public ResponseEntity<HttpStatus> deleteUserProfile(
            @PathVariable(name = "userId") UUID id){

        userService.deleteUserProfile(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<ProfileReadResponse> getUserProfile(
            @PathVariable(name = "userId") UUID id){

        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/bio/{userId}")
    public ResponseEntity<HttpStatus> updateUserBio(
            @PathVariable(name = "userId") UUID id,
            @Valid @RequestBody UpdateBioRequest request){

        userBioService.updateUserBio(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/bio/{userId}")
    public ResponseEntity<BioReadResponse> getUserBio(
            @PathVariable(name = "userId") UUID id){

        return ResponseEntity.ok(userBioService.findByUserId(id));
    }

    @PostMapping("/genre-preferences")
    public ResponseEntity<HttpStatus> addUserGenrePreference(
            @Valid @RequestBody AddGenreRequest request){

        userGenrePreferenceService.addUserGenrePreference(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/genre-preferences/{userId}")
    public ResponseEntity<Set<UserGenrePreference>> getUserGenrePreference(
            @PathVariable(name = "userId") UUID id){

        return ResponseEntity.ok(userGenrePreferenceService.findByUserId(id));
    }

    @DeleteMapping("/genre-preferences/{genreId}")
    public ResponseEntity<HttpStatus> deleteUserGenrePreference(
            @PathVariable(name = "genreId") UUID id){

        userGenrePreferenceService.deleteUserGenrePreference(id);
        return ResponseEntity.ok().build();
    }
}