package com.example.projet.competence.mycomp.personnes;

import com.example.projet.competence.mycomp.competences.Competence;
import lombok.Data;

@Data
public class PersonneMinimalDTO {
    private String id;
    private String nom;
    private String prenom;
    private Competence meilleureCompetence;
}
