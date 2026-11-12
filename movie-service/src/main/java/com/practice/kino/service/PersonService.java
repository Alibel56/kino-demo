package com.practice.kino.service;

import com.practice.kino.dto.request.PersonRequest;
import com.practice.kino.dto.response.PersonReadResponse;

import java.util.UUID;

public interface PersonService {
    public void addPerson(PersonRequest person);
    public void updatePerson(PersonRequest person);
    public void deletePerson(UUID personId);
    public PersonReadResponse findPersonById(UUID personId);
}
