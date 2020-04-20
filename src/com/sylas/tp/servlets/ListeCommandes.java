package com.sylas.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListeCommandes
 */
@WebServlet( "/ListeCommandes" )
public class ListeCommandes extends HttpServlet {
    private static final long  serialVersionUID = 1L;

    public static final String ATT_CLIENT       = "commande";
    public static final String ATT_FORM         = "form";

    public static final String VUE              = "/WEB-INF/listeCommandes.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeCommandes() {
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
//        response.getWriter().append( "Served at: " ).append( request.getContextPath() );
        /* À la réception d'une requête GET, affichage de la liste des commandes */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
//        doGet( request, response );
    }

}
