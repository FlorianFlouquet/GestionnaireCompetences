package com.example.projet.competence.mycomp.competences;

import com.example.projet.competence.mycomp.personnes.Personne;

import java.util.List;

public interface CompetenceService {
    List<Competence> findAll();

    Competence save(Competence entity);

    Competence findById(String id);

    void deleteById(String id);
}
