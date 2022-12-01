package com.example.projet.competence.mycomp.competences;

import com.example.projet.competence.mycomp.personnes.PersonneRepository;
import com.example.projet.competence.mycomp.personnes.PersonneService;
import com.example.projet.competence.mycomp.personnes.PersonneServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompetenceConfiguration {

    @Bean
    public CompetenceService competenceService(CompetenceRepository competenceRepository) {
        return new CompetenceServiceImpl(competenceRepository);
    }
}
