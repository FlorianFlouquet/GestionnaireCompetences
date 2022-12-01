package com.example.projet.competence.mycomp.personnes;

import java.util.List;

public interface PersonneService {
    List<Personne> findAll();

    Personne save(Personne entity);

    Personne findById(String id);

    void deleteById(String id);

    Personne ajouterCompetence(String personneId, String competenceId, Integer niveau);
}
