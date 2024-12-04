package org.example.services;

import org.example.models.Utilisateur;
import org.mindrot.jbcrypt.BCrypt;
public class UtilisateurService {

    private UtilisateurDAO utilisateurDAO;

    public UtilisateurService() {
        utilisateurDAO = new UtilisateurDAO();
    }

    public Utilisateur login(String email, String password) {
        System.out.println("Login attempt for email: " + email);  // Debug: Log the email
        Utilisateur utilisateur = utilisateurDAO.findByEmail(email);  // Find user by email

        if (utilisateur != null) {  // If the user is found
            System.out.println("User found: " + utilisateur);  // Debug: Log the found user
            System.out.println("Stored password: " + utilisateur.getMotDePasse());  // Debug: Log the stored password hash
            System.out.println("Input password: " + password);  // Debug: Log the input password

            // Check if the input password matches the stored hashed password
            if (BCrypt.checkpw(password, utilisateur.getMotDePasse())) {
                System.out.println("Password match!");  // Password is correct
                return utilisateur;  // Return the user object if valid credentials
            } else {
                System.out.println("Invalid password!");  // Invalid password
            }
        } else {
            System.out.println("User not found!");  // No user found for the given email
        }
        return null;  // Return null if credentials are invalid or user not found
    }



    public boolean register(Utilisateur utilisateur) {
        if (utilisateurDAO.findByEmail(utilisateur.getEmail()) == null) {
            String hashedPassword = BCrypt.hashpw(utilisateur.getMotDePasse(), BCrypt.gensalt());
            utilisateur.setMotDePasse(hashedPassword);
            return utilisateurDAO.save(utilisateur);
        }
        return false; // Email already exists
    }
}
