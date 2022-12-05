package com.example.projet.competence.mycomp.personnes;

import com.example.projet.competence.mycomp.personnes.dto.PersonneMinimalDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personnes")
public class PersonneController {
    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("")
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    @PostMapping("")
    public Personne save(@RequestBody Personne entity) {
        return personneService.save(entity);
    }

    @GetMapping("{id}")
    public Personne findById(@PathVariable String id) {
        return personneService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        personneService.deleteById(id);
    }

    @PutMapping("{personId}/competences/{competenceId}")
    public Personne ajouterCompetenceOuModifier(@PathVariable String personId, @PathVariable String competenceId, @RequestParam Integer niveau) {
        return personneService.ajouterOuModifierCompetence(personId, competenceId, niveau);
    }

    @DeleteMapping("{personId}/competences/{competenceId}")
    public void supprimeCompetenceDePersonne(@PathVariable String personId, @PathVariable String competenceId) {
        this.personneService.supprimeCompetenceDePersonne(personId, competenceId);
    }

    @GetMapping("/competences/{id}")
    public List<Personne> rechercherPersonneParNiveauCompetence(@PathVariable String id, @RequestParam Integer niveau) {
        return this.personneService.rechercherPersonneParNiveauCompetence(id, niveau);
    }
}
