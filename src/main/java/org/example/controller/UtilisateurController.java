package org.example.controller;

import org.example.models.Utilisateur;
import org.example.services.UtilisateurService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UtilisateurController")
public class UtilisateurController extends HttpServlet {

    private UtilisateurService utilisateurService;

    @Override
    public void init() throws ServletException {
        utilisateurService = new UtilisateurService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer le paramètre "action"
        String action = request.getParameter("action");

        if ("register".equalsIgnoreCase(action)) {
            handleRegistration(request, response);
        } else if ("login".equalsIgnoreCase(action)) {
            handleLogin(request, response);
        } else {
            redirectToErrorPage(request, response, "Action non prise en charge.");
        }
    }

    private void handleRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if (nom == null || email == null || password == null || role == null ||
                nom.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
            request.setAttribute("error", "Tous les champs sont requis.");
            forwardToRegisterPage(request, response);
            return;
        }

        try {
            // Créer un utilisateur et appeler le service
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(nom);
            utilisateur.setEmail(email);
            utilisateur.setMotDePasse(password); // À remplacer par un hachage de mot de passe
            utilisateur.setRole(role);

            boolean isCreated = utilisateurService.register(utilisateur);

            if (isCreated) {
                response.sendRedirect("./login.jsp");
            } else {
                request.setAttribute("error", "Échec de l'inscription. Veuillez réessayer.");
                forwardToRegisterPage(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Une erreur est survenue lors de l'inscription.");
            forwardToRegisterPage(request, response);
        }
    }

    private void forwardToRegisterPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("./register.jsp");
        dispatcher.forward(request, response);
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            redirectToErrorPage(request, response, "Email et mot de passe sont requis.");
            return;
        }

        try {
            Utilisateur utilisateur = utilisateurService.login(email, password);

            if (utilisateur != null) {
                HttpSession session = request.getSession();
                session.setAttribute("utilisateur", utilisateur);

                if ("formateur".equalsIgnoreCase(utilisateur.getRole())) {
                    response.sendRedirect("./dashboardFormateur");
                } else if ("etudiant".equalsIgnoreCase(utilisateur.getRole())) {
                    response.sendRedirect("./dashboardEtudiant");
                } else {
                    redirectToErrorPage(request, response, "Rôle utilisateur inconnu.");
                }
            } else {
                redirectToErrorPage(request, response, "Email ou mot de passe invalide.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectToErrorPage(request, response, "Une erreur est survenue lors de la connexion.");
        }
    }

    private void redirectToErrorPage(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./error.jsp");
        dispatcher.forward(request, response);
    }
}
