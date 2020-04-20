package com.sylas.tp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sylas.tp.beans.Client;
import com.sylas.tp.forms.CreationClientForm;

/**
 * Servlet implementation class CreationClient
 */
// @WebServlet("/creetionClient")
public class CreationClient extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    /* Constantes */

    public static final String  CHAMP_NOM        = "nomClient";
    // public static final String CHAMP_PRENOM = "prenomClient";
    // public static final String CHAMP_ADRESSE = "adresseClient";
    // public static final String CHAMP_TELEPHONE = "telephoneClient";
    // public static final String CHAMP_EMAIL = "emailClient";

    // public static final String ATT_CLIENT = "client";
    // public static final String ATT_MESSAGE = "message";
    // public static final String ATT_ERREUR = "erreur";
    public static final String  SESSION_CLIENTS  = "clients";
    public static final String  ATT_FORM         = "form";
    public static final String  ATT_USER         = "client";

    public static final String  VUE_FORM         = "/WEB-INF/creerClient.jsp";
    public static final String  VUE_SUCCES       = "/WEB-INF/afficherClient.jsp";

    private Map<String, Client> saveClient       = new HashMap<String, Client>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        CreationClientForm form = new CreationClientForm();

        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en résultant
         */

        Client client = form.creerClient( request );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, client );

        // if ( form.getErreurs().isEmpty() ) {
        // /* Si aucune erreur, alors affichage de la fiche récapitulative */
        // this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward(
        // request, response );
        // } else {
        // /* Sinon, ré-affichage du formulaire de création avec les erreurs */
        // this.getServletContext().getRequestDispatcher( VUE_FORM ).forward(
        // request, response );
        // }

        /* Si aucune erreur */
        if ( form.getErreurs().isEmpty() ) {
            /* Alors récupération de la map des clients dans la session */
            HttpSession session = request.getSession();
            Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute( SESSION_CLIENTS );
            /*
             * Si aucune map n'existe, alors initialisation d'une nouvelle map
             */
            if ( clients == null ) {
                clients = new HashMap<String, Client>();
            }
            /* Puis ajout du client courant dans la map */
            clients.put( client.getNomClient(), client );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_CLIENTS, clients );

            /* Affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
    // this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward(
    // request, response );
}

/****
 * avant la remise a niveau
 */
// /**
// * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
// * response)
// */
// protected void doGet( HttpServletRequest request, HttpServletResponse
// response )
// throws ServletException, IOException {
// // TODO Auto-generated method stub
// // response.getWriter().append("Served at:
// // ").append(request.getContextPath());
// // recuperartion des donnees
//
// String nom = request.getParameter( CHAMP_NOM );
// String prenom = request.getParameter( CHAMP_PRENOM );
// String adresse = request.getParameter( CHAMP_ADRESSE );
// String telephone = request.getParameter( CHAMP_TELEPHONE );
// String email = request.getParameter( CHAMP_EMAIL );
// String message;
// boolean erreur;
// /*
// * Initialisation du message à afficher : si un des champs obligatoires
// * du formulaire n'est pas renseigné, alors on affiche un message
// * d'erreur, sinon on affiche un message de succès
// */
//
// if ( nom.trim().isEmpty() || adresse.trim().isEmpty() ||
// telephone.trim().isEmpty() ) {
//
// // if(nom == null || adresse == null || telephone == null) {
// message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br>
// <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de
// création d'un client.";
// erreur = true;
// } else {
// message = "Client créé avec succès !";
// erreur = false;
// }
//
// /*
// * Création du bean Client et initialisation avec les données récupérées
// */
//
// Client client = new Client();
// client.setNomClient( nom );
// client.setPrenomClient( prenom );
// client.setAdresseClient( adresse );
// client.setTelephoneClient( telephone );
// client.setEmailClient( email );
//
// /**
// * transmission de la bine et du message
// */
// request.setAttribute( ATT_MESSAGE, message );
// request.setAttribute( ATT_CLIENT, client );
// request.setAttribute( ATT_ERREUR, erreur );
//
// /* Transmission à la page JSP en charge de l'affichage des données */
// this.getServletContext().getRequestDispatcher( VUE ).forward( request,
// response );
// }
//
// /**
// * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
// * response)
// */
// protected void doPost( HttpServletRequest request, HttpServletResponse
// response )
// throws ServletException, IOException {
// // TODO Auto-generated method stub
// doGet( request, response );
// }
//
// }
