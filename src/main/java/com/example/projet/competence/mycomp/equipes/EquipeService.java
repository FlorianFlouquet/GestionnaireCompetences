package com.example.projet.competence.mycomp.equipes;

import com.example.projet.competence.mycomp.equipes.Equipe;

import java.util.List;

public interface EquipeService {
    List<Equipe> findAll();

    Equipe save(Equipe entity);

    Equipe findById(String id);

    void deleteById(String id);

    /**
     * Ajoute un membre à l'équipe
     * @param idEquipe
     * @param idMembre
     * @return
     */
    Equipe ajoutMembre(String idEquipe, String idMembre);

    /**
     * Retire un membre d'une équipe
     * @param idEquipe
     * @param idMembre
     */
    void retirerMembre(String idEquipe, String idMembre);
}
