package com.example.projet.competence.mycomp.equipes;

import com.example.projet.competence.mycomp.personnes.Personne;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipeRepository extends MongoRepository<Equipe, String> {
}
