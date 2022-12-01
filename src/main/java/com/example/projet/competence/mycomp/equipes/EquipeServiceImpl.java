package com.example.projet.competence.mycomp.equipes;

import com.example.projet.competence.mycomp.personnes.Personne;
import com.example.projet.competence.mycomp.personnes.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository equipeRepository;
    private final PersonneService personneService;


    public EquipeServiceImpl(EquipeRepository equipeRepository, PersonneService personneService) {
        this.equipeRepository = equipeRepository;
        this.personneService = personneService;
    }

    @Override
    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe save(Equipe entity) {
        for(Personne membre: entity.getMembres()) {
            if(membre.getId() == null) {
               personneService.save(membre);
            }
        }
        return equipeRepository.save(entity);
    }

    @Override
    public Equipe findById(String id) {
        return equipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe ajoutMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        Personne membre = this.personneService.findById(idMembre);
        if(equipe.getMembres().stream().noneMatch(emembre -> emembre.getId().equals(idMembre))) {
            equipe.getMembres().add(membre);
        }
        return this.save(equipe);
    }

    @Override
    public void retirerMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        Personne membre = this.personneService.findById(idMembre);
        if(equipe.getMembres().stream().anyMatch(emembre -> emembre.getId().equals(idMembre))) {
            equipe.getMembres().remove(membre);
        }
        this.save(equipe);
    }
}
