package org.example.services;

import org.example.models.Utilisateur;

import java.sql.*;

public class UtilisateurDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/platform?useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    public Utilisateur findByEmail(String email) {
        Utilisateur utilisateur = null;
        String query = "SELECT * FROM utilisateurs WHERE email = ?";  // Use parameterized query

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);  // Set the email parameter dynamically

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    utilisateur = new Utilisateur();
                    utilisateur.setId(resultSet.getInt("id"));
                    utilisateur.setNom(resultSet.getString("nom"));
                    utilisateur.setEmail(resultSet.getString("email"));
                    utilisateur.setMotDePasse(resultSet.getString("motDePasse"));
                    utilisateur.setRole(resultSet.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return utilisateur;
    }




    public boolean save(Utilisateur utilisateur) {
        String query = "INSERT INTO utilisateurs (nom, email, motDePasse, role) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, utilisateur.getNom());
            statement.setString(2, utilisateur.getEmail());
            statement.setString(3, utilisateur.getMotDePasse());
            statement.setString(4, utilisateur.getRole());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
