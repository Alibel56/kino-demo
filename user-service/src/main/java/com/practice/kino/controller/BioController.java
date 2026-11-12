package com.practice.kino.controller;

import com.practice.kino.dto.request.UpdateBioRequest;
import com.practice.kino.dto.response.BioReadResponse;
import com.practice.kino.service.UserBioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class BioController {

    private final UserBioService userBioService;

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
}
