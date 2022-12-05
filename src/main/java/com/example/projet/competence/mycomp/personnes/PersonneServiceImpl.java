package com.example.projet.competence.mycomp.personnes;

import com.example.projet.competence.mycomp.competences.CompetenceService;
import com.example.projet.competence.mycomp.personnes.dto.PersonneMinimalDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class PersonneServiceImpl implements PersonneService {

    private final PersonneRepository personneRepository;
    private final CompetenceService competenceService;
    private final ObjectMapper objectMapper;

    public PersonneServiceImpl(PersonneRepository personneRepository, CompetenceService competenceService, ObjectMapper objectMapper) {
        this.personneRepository = personneRepository;
        this.competenceService = competenceService;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Personne> findAll() {
//        List<Personne> listePersonnes = personneRepository.findAll(PageRequest.of(0,10)).toList();
//        List<Personne> listePersonnes = personneRepository.findAll();
//        List<PersonneMinimalDTO> listePersonnesMinimal = new ArrayList<>();
//        for (Personne personne : listePersonnes) {
//            listePersonnesMinimal.add(this.objectMapper.convertValue(personne, PersonneMinimalDTO.class));
//        }
//        return listePersonnesMinimal;
//        return objectMapper.convertValue(
//                listePersonnes,
//                new TypeReference<List<PersonneMinimalDTO>>() {}
//        );
        return this.personneRepository.findAll();
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

    /**
     * Dans le cas où la compétence existe déjà dans le membre, modifie son niveau.
     * Sinon ajoute la compétence.
     * * @param personneId
     * @param competenceId
     * @param niveau
     * @return
     */
    @Override
    public Personne ajouterOuModifierCompetence(String personneId, String competenceId, Integer niveau) {
        Personne membre = this.findById(personneId);
        List<NiveauCompetence> listeNiveauCompetence = membre.getCompetences();
        if(membre.getCompetences().stream().noneMatch(niveauCompetence -> niveauCompetence.getCompetence().getId().equals(competenceId))) {
            NiveauCompetence niveauCompetence = new NiveauCompetence(this.competenceService.findById(competenceId), niveau);
            membre.getCompetences().add(niveauCompetence);
        } else {
            for(NiveauCompetence niveauCompetence: listeNiveauCompetence) {
                if(niveauCompetence.getCompetence().getId().equals(competenceId)) {
                    niveauCompetence.setNiveau(niveau);
                }
            }
        }
        return this.save(membre);
    }

    /**
     * Supprime la competence passée en paramètre d'un utilisateur
      * @param personneId
     * @param competenceId
     */
    @Override
    public void supprimeCompetenceDePersonne(String personneId, String competenceId) {
        Personne membre = this.findById(personneId);
        List<NiveauCompetence> listeNiveauCompetence = membre.getCompetences();
        List<NiveauCompetence> newListe = new ArrayList<>();
        for(NiveauCompetence niveauCompetence : listeNiveauCompetence) {
            if(!niveauCompetence.getCompetence().getId().equals(competenceId)) {
                newListe.add(niveauCompetence);
            }
        }
        if(listeNiveauCompetence.size() == newListe.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        membre.setCompetences(newListe);
        this.save(membre);
    }

    /**
     * Prend l'ensemble des personnes dans la db et retourne les personnes avec un niveau de compétences supérieur
     * ou égale à la valeur indiquée en paramètre
     * @param id
     * @param niveau
     * @return
     */
    @Override
    public List<Personne> rechercherPersonneParNiveauCompetence(String id, Integer niveau) {
        List<Personne> personneList = this.personneRepository.findAll();
        List<Personne> newList = new ArrayList<>();
        // Itére sur la liste des personnes
        for(Personne personne : personneList) {
            List<NiveauCompetence> niveauCompetenceList = personne.getCompetences();
            // Itére sur la liste des compétences d'une personne
            for(NiveauCompetence niveauCompetence : niveauCompetenceList) {
                // Regarde si l'id dans le niveau de compétence correspond à l'id en parametre
                if(niveauCompetence.getCompetence() != null && niveauCompetence.getCompetence().getId().equals(id) && niveauCompetence.getNiveau() >= niveau) {
                    // Si le niveau de la competence est supérieur à égal au parametre, ajoute la personne dans la liste
                    newList.add(personne);
                }
            }
        }
        return newList;
    }
}
