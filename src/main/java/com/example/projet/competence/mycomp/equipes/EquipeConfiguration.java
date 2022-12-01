package com.example.projet.competence.mycomp.equipes;

import com.example.projet.competence.mycomp.personnes.PersonneRepository;
import com.example.projet.competence.mycomp.personnes.PersonneService;
import com.example.projet.competence.mycomp.personnes.PersonneServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EquipeConfiguration {

    @Bean
    public EquipeService equipeService(EquipeRepository equipeRepository) {
        return new EquipeServiceImpl(equipeRepository);
    }
}
