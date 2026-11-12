package com.practice.kino.service.impl;

import com.practice.kino.dto.request.PersonRequest;
import com.practice.kino.dto.response.PersonReadResponse;
import com.practice.kino.repository.PersonRepository;
import com.practice.kino.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public void addPerson(PersonRequest person) {

    }

    @Override
    public void updatePerson(PersonRequest person) {

    }

    @Override
    public void deletePerson(UUID personId) {

    }

    @Override
    public PersonReadResponse findPersonById(UUID personId){
        return null;
    }
}
