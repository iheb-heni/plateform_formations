package org.example.models;


import java.util.List;

public class Formateur extends Utilisateur {
    private List<Formation> formations;

    // Constructor
    public Formateur(int id ,String nom, String email, String motDePasse, List<Formation> formations) {
        super(id ,nom, email, motDePasse, "formateur");
        this.formations = formations;
    }

    // Getter and Setter for formations
    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    // Method to add a new formation
    public void ajouterFormation(Formation formation) {
        formations.add(formation);
    }
}