package com.example.projet.competence.mycomp.personnes;

import com.example.projet.competence.mycomp.competences.CompetenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonneConfiguration {

    @Bean
    public PersonneService personneService(PersonneRepository personneRepository, CompetenceService competenceService) {
        return new PersonneServiceImpl(personneRepository, competenceService);
    }
}
