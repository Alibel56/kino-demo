package com.practice.kino.controller;

import com.practice.kino.dto.request.AddGenreRequest;
import com.practice.kino.dto.response.GenreReadResponse;
import com.practice.kino.service.GenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @PostMapping("/genre")
    public ResponseEntity<HttpStatus> addGenre(
            @Valid @RequestBody AddGenreRequest request
    ){
        genreService.addGenre(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/genre/{genreId}")
    public ResponseEntity<HttpStatus> deleteGenre(
            @PathVariable(name = "genreId") UUID id
    ){
        genreService.deleteGenre(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<GenreReadResponse> getGenreById(
            @PathVariable(name = "genreId") UUID id
    ){
        return ResponseEntity.ok(genreService.findGenreById(id));
    }
}
