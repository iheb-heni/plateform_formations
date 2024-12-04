package org.example.models;


import org.example.exceptions.FormationDejaInscriteException;

import java.util.ArrayList;
import java.util.List;
public class Etudiant extends Utilisateur {
    private List<Formation> inscriptions;

    // Constructor
    public Etudiant(int id ,String nom, String email, String motDePasse) {
        super(id , nom, email, motDePasse, "etudiant");
        this.inscriptions = new ArrayList<>();
    }

    // Method to register for a formation
    public void inscrireFormation(Formation formation) throws FormationDejaInscriteException {
        if (inscriptions.contains(formation)) {
            throw new FormationDejaInscriteException("Formation déjà inscrite.");
        }
        inscriptions.add(formation);
    }

    // Getters and Setters
    public List<Formation> getInscriptions() {
        return inscriptions;
    }
}