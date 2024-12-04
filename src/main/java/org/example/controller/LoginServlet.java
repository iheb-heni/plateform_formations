package org.example.controller;

import org.example.models.Utilisateur;
import org.example.services.UtilisateurService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UtilisateurService utilisateurService;

    @Override
    public void init() throws ServletException {
        // Initialize the UtilisateurService instance
        utilisateurService = new UtilisateurService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the login page on GET request
        forwardToPage("/login.jsp", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate input
        if (isNullOrEmpty(email) || isNullOrEmpty(password)) {
            request.setAttribute("error", "Email and password cannot be empty.");
            forwardToPage("/login.jsp", request, response);
            return;
        }

        try {
            // Authenticate user
            Utilisateur utilisateur = utilisateurService.login(email, password);

            if (utilisateur != null) {
                // Successful login: create session and redirect based on role
                HttpSession session = request.getSession();
                session.setAttribute("utilisateur", utilisateur);
                redirectBasedOnRole(utilisateur.getRole(), response);
            } else {
                // Failed login: set error message and forward to login page
                request.setAttribute("error", "Invalid email or password.");
                request.setAttribute("email", email); // Preserve email for convenience
                forwardToPage("/login.jsp", request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An unexpected error occurred. Please try again later.");
            forwardToPage("/login.jsp", request, response);
        }
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private void redirectBasedOnRole(String role, HttpServletResponse response) throws IOException {
        if ("formateur".equalsIgnoreCase(role)) {
            response.sendRedirect("./dashboardFormateur");
        } else if ("etudiant".equalsIgnoreCase(role)) {
            response.sendRedirect("./dashboardEtudiant");
        } else {
            response.sendRedirect("./defaultDashboard");
        }
    }

    private void forwardToPage(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
