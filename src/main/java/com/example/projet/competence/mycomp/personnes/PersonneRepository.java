package com.example.projet.competence.mycomp.personnes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonneRepository extends MongoRepository<Personne, String> {
}
