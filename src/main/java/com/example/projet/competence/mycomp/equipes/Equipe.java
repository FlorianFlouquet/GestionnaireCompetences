package com.example.projet.competence.mycomp.equipes;

import com.example.projet.competence.mycomp.personnes.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Equipe {
    @Id
    private String id;
    private String nom;
    @DBRef
    private List<Personne> membres = new ArrayList<>();
}
