package com.practice.kino.controller;

import com.practice.kino.dto.request.PersonRequest;
import com.practice.kino.dto.response.PersonReadResponse;
import com.practice.kino.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<HttpStatus> addPerson(
            @Valid @RequestBody PersonRequest request
    ){
        personService.addPerson(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/person/{personId}")
    public ResponseEntity<HttpStatus> updatePerson(
            @PathVariable UUID personId,
            @Valid @RequestBody PersonRequest request
    ){
        personService.updatePerson(personId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/person/{personId}")
    public ResponseEntity<HttpStatus> deletePerson(
            @PathVariable UUID personId
    ){
        personService.deletePerson(personId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<PersonReadResponse> getPerson(
            @PathVariable UUID personId)
    {
        return ResponseEntity.ok(personService.findPersonById(personId));
    }
}
