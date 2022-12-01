package com.example.projet.competence.mycomp.personnes;

import com.example.projet.competence.mycomp.competences.Competence;
import com.example.projet.competence.mycomp.competences.CompetenceService;
import com.example.projet.competence.mycomp.competences.CompetenceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class PersonneServiceImpl implements PersonneService {

    private final PersonneRepository personneRepository;
    private final CompetenceService competenceService;


    public PersonneServiceImpl(PersonneRepository personneRepository, CompetenceService competenceService) {
        this.personneRepository = personneRepository;
        this.competenceService = competenceService;
    }

    @Override
    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    @Override
    public Personne save(Personne entity) {
        return personneRepository.save(entity);
    }

    @Override
    public Personne findById(String id) {
        return personneRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        personneRepository.deleteById(id);
    }

    @Override
    public Personne ajouterCompetence(String personneId, String competenceId, Integer niveau) {
        Personne membre = this.findById(personneId);
        Competence competence = this.competenceService.findById(competenceId);
        List<NiveauCompetence> listeNiveauCompetence = membre.getCompetences();
        NiveauCompetence nouveauNiveauCompetence = new NiveauCompetence();
        for(NiveauCompetence niveauCompetence : listeNiveauCompetence) {
            if(niveauCompetence.getCompetence().getId().equals(competenceId)) {
                nouveauNiveauCompetence.setCompetence(competence);
                nouveauNiveauCompetence.setNiveau(niveau);
            }
        }
        membre.getCompetences().add(nouveauNiveauCompetence);
        return this.save(membre);
    }


}
