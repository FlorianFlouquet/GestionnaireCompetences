package com.example.projet.competence.mycomp.equipes;

import com.example.projet.competence.mycomp.equipes.Equipe;

import java.util.List;

public interface EquipeService {
    List<Equipe> findAll();

    Equipe save(Equipe entity);

    Equipe findById(String id);

    void deleteById(String id);
}
