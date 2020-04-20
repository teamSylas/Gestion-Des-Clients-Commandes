package com.sylas.tp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sylas.tp.beans.Client;

/**
 * Servlet implementation class SuppressionClient
 */
@WebServlet( "/SuppressionClient" )
public class SuppressionClient extends HttpServlet {
    private static final long  serialVersionUID = 1L;
    public static final String PARAM_NOM_CLIENT = "nomClient";
    public static final String SESSION_CLIENTS  = "clients";

    public static final String VUE              = "/listeClients";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at:
        // ").append(request.getContextPath());

        /* Récupération du paramètre */
        String nomClient = getValeurParametre( request, PARAM_NOM_CLIENT );

        /* Récupération de la Map des clients enregistrés en session */
        HttpSession session = request.getSession();
        Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute( SESSION_CLIENTS );

        /* Si le nom du client et la Map des clients ne sont pas vides */
        if ( nomClient != null && clients != null ) {
            /* Alors suppression du client de la Map */
            clients.remove( nomClient );
            /* Et remplacement de l'ancienne Map en session par la nouvelle */
            session.setAttribute( SESSION_CLIENTS, clients );
        }

        /* Redirection vers la fiche récapitulative */
        response.sendRedirect( request.getContextPath() + VUE );
    }

    /*
     * Méthode utilitaire qui retourne null si un paramètre est vide, et son
     * contenu sinon.
     */
    private static String getValeurParametre( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}
