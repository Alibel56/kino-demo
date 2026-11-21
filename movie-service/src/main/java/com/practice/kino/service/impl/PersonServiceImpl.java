package com.practice.kino.service.impl;

import com.practice.kino.dto.request.PersonRequest;
import com.practice.kino.dto.response.PersonReadResponse;
import com.practice.kino.entity.Person;
import com.practice.kino.mapper.PersonMapper;
import com.practice.kino.repository.PersonRepository;
import com.practice.kino.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    @Override
    public void addPerson(PersonRequest request) {
        personRepository.save(personMapper.toEntity(request));
    }

    @Override
    public void updatePerson(UUID personId, PersonRequest request) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("person not found!"));

        personMapper.updateEntity(request,person);
        personRepository.save(person);
    }

    @Override
    public void deletePerson(UUID personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public PersonReadResponse findPersonById(UUID personId){
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("person not found!"));

        return  personMapper.toResponse(person);
    }
}
