package org.example.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer le message d'erreur
        String errorMessage = (String) request.getAttribute("errorMessage");

        // Si aucun message d'erreur n'est spécifié, utiliser un message par défaut
        if (errorMessage == null) {
            errorMessage = "Une erreur inattendue est survenue.";
        }

        // Stocker le message dans l'objet request et rediriger vers une page JSP d'erreur
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
        dispatcher.forward(request, response);
    }
}
