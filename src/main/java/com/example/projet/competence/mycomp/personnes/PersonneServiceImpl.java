package com.example.projet.competence.mycomp.personnes;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneServiceImpl {

    private final PersonneRepository personneRepository;


    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    public Personne save(Personne entity) {
        return personneRepository.save(entity);
    }

    public Personne findById(String id) {
        return personneRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(String id) {
        personneRepository.deleteById(id);
    }
}
