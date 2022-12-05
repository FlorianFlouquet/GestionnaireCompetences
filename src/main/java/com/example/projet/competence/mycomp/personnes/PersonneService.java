package com.example.projet.competence.mycomp.personnes;

import com.example.projet.competence.mycomp.personnes.dto.PersonneMinimalDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PersonneService {
    List<Personne> findAll();

    Personne save(Personne entity);

    Personne findById(String id);

    void deleteById(String id);

    Personne ajouterOuModifierCompetence(String personneId, String competenceId, Integer niveau);

    void supprimeCompetenceDePersonne(String personneId, String competenceId);

    List<Personne> rechercherPersonneParNiveauCompetence(String id, Integer niveau);
}
