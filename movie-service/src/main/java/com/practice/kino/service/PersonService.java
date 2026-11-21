package com.practice.kino.service;

import com.practice.kino.dto.request.PersonRequest;
import com.practice.kino.dto.response.PersonReadResponse;

import java.util.UUID;

public interface PersonService {
    void addPerson(PersonRequest request);
    void updatePerson(UUID personId, PersonRequest request);
    void deletePerson(UUID personId);
    PersonReadResponse findPersonById(UUID personId);
}
