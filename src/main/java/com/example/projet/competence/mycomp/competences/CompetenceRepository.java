package com.example.projet.competence.mycomp.competences;

import com.example.projet.competence.mycomp.personnes.Personne;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetenceRepository extends MongoRepository<Competence, String> {
}
