package org.example.controller;

import org.example.models.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dashboardFormateur")
public class DashboardFormateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupère la session HTTP existante
        HttpSession session = req.getSession(false);

        // Vérifie si la session existe et si un utilisateur est connecté
        if (session != null) {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

            // Vérifie que l'utilisateur est authentifié et qu'il a le rôle "formateur"
            if (utilisateur != null && "formateur".equalsIgnoreCase(utilisateur.getRole())) {
                // Prépare les données nécessaires pour le tableau de bord (si nécessaire)

                // Redirige vers la page du tableau de bord
                RequestDispatcher dispatcher = req.getRequestDispatcher("./dashboardFormateur.jsp");
                dispatcher.forward(req, resp);
                return;
            }
        }

        // Si l'utilisateur n'est pas authentifié ou n'a pas le rôle approprié, redirige vers une page d'erreur ou de login
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
