package com.example.projet.competence.mycomp.personnes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonneConfiguration {

    @Bean
    public PersonneService personneService(PersonneRepository personneRepository) {
        return new PersonneServiceImpl(personneRepository);
    }
}
