package org.example.models;

public class Utilisateur {
    private int id;
    private String nom;
    private String email;
    private String motDePasse;
    private String role;  // Formateur or Etudiant

    // Constructor
    public Utilisateur(int id, String nom, String email, String motDePasse, String role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public Utilisateur() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;  // Set the id field correctly
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{id=" + id + ", nom='" + nom + "', email='" + email +"', motDePasse='" + motDePasse + "', role='" + role + "'}";
    }
}
