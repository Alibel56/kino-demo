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

    @PostMapping("/profile")
    public ResponseEntity<ProfileReadResponse> createUser(
            @Valid @RequestBody CreateUserRequest request
    ) {
        return ResponseEntity.ok(userService.createUserProfile(request));
    }

    @PatchMapping("/profile/{userId}")
    public ResponseEntity<HttpStatus> updateUserProfile(
            @PathVariable UUID userId,
            @Valid @RequestBody UpdateProfileRequest request
    ){
        userService.updateUserProfile(userId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/profile/{userId}")
    public ResponseEntity<HttpStatus> deleteUserProfile(
            @PathVariable UUID userId
    ){
        userService.deleteUserProfile(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<ProfileReadResponse> getUserProfile(
            @PathVariable UUID userId
    ){
        return ResponseEntity.ok(userService.findById(userId));
    }
}