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
import com.sylas.tp.beans.Commande;
import com.sylas.tp.forms.CreationCommandeForm;

/**
 * Servlet implementation class CreationCommande
 */
// @WebServlet("/creationCommande")
public class CreationCommande extends HttpServlet {
    private static final long  serialVersionUID  = 1L;
    // public static final String CHAMP_NOM = "nomClient";
    // public static final String CHAMP_PRENOM = "prenomClient";
    // public static final String CHAMP_ADRESSE = "adresseClient";
    // public static final String CHAMP_TELEPHONE = "telephoneClient";
    // public static final String CHAMP_EMAIL = "emailClient";
    public static final String ATT_SESSION_USER  = "sessionUtilisateur";

    public static final String FORMAT_DATE       = "dd/MM/yyyy HH:mm:ss";
    // public static final String CHAMP_MONTANT = "montantCommande";
    // public static final String CHAMP_MODE_PAIEMENT = "modePaiementCommande";
    // public static final String CHAMP_STATUT_PAIEMENT =
    // "statutPaiementCommande";
    // public static final String CHAMP_MODE_LIVRAISON =
    // "modeLivraisonCommande";
    // public static final String CHAMP_STATUT_LIVRAISON =
    // "statutLivraisonCommande";

    public static final String ATT_COMMANDE      = "commande";
    // public static final String ATT_MESSAGE = "message";
    public static final String ATT_FORM          = "form";
    public static final String SESSION_COMMANDES = "commandes";
    public static final String SESSION_CLIENTS   = "clients";

    public static final String VUE_FROM          = "/WEB-INF/creerCommande.jsp";
    public static final String VUE_SUCCES        = "/WEB-INF/afficherCommande.jsp";

    // private Map<String, Commande> saveCommande = new HashMap<String,
    // Commande>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE_FROM ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // recuperation des donnee
        CreationCommandeForm form = new CreationCommandeForm();

        // traitement des donee

        Commande commande = form.creerCommande( request );

        // /* Récupération de la session depuis la requête */
        // HttpSession session = request.getSession();
        //
        // /* Recuperation de la date de la commamnde */
        // DateTime dt = new DateTime();
        // DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE
        // );
        // String date = dt.toString( formatter );
        //
        // /* ajoute de la commade a la sessiont */
        //
        // if ( form.getErreurs().isEmpty() ) {
        // session.setAttribute( ATT_SESSION_USER, commande );
        // } else {
        // session.setAttribute( ATT_SESSION_USER, null );
        // }

        // transmissions des donnees

        request.setAttribute( ATT_COMMANDE, commande );
        request.setAttribute( ATT_FORM, form );

        // if ( form.getErreurs().isEmpty() ) {
        // this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward(
        // request, response );
        // } else {
        // this.getServletContext().getRequestDispatcher( VUE_FROM ).forward(
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
            /* Puis ajout du client de la commande courante dans la map */
            clients.put( commande.getClient().getNomClient(), commande.getClient() );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_CLIENTS, clients );

            /* Ensuite récupération de la map des commandes dans la session */
            Map<String, Commande> commandes = (HashMap<String, Commande>) session.getAttribute( SESSION_COMMANDES );
            /*
             * Si aucune map n'existe, alors initialisation d'une nouvelle map
             */
            if ( commandes == null ) {
                commandes = new HashMap<String, Commande>();
            }
            /* Puis ajout de la commande courante dans la map */
            commandes.put( commande.getDate(), commande );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_COMMANDES, commandes );

            /* Affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FROM ).forward( request, response );
        }
    }

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
    //
    // // recupreation des donneer envoyer GET pour le client
    //
    // String nom = request.getParameter( CHAMP_NOM );
    // String prenom = request.getParameter( CHAMP_PRENOM );
    // String adresse = request.getParameter( CHAMP_ADRESSE );
    // String telephone = request.getParameter( CHAMP_TELEPHONE );
    // String email = request.getParameter( CHAMP_EMAIL );
    //
    // // recuperatrion de la date courrant
    //
    // DateTime dt = new DateTime();
    //
    // /* Conversion de la date en String selon le format défini */
    //
    // DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
    // String date = dt.toString( formatter );
    //
    // /**
    // * Les montants
    // */
    // double montant;
    // try {
    // /* Récupération du montant */
    // montant = Double.parseDouble( request.getParameter( CHAMP_MONTANT ) );
    // } catch ( NumberFormatException e ) {
    // /* Initialisation à -1 si le montant n'est pas un nombre correct */
    // montant = -1;
    // }
    //
    // String modePaiement = request.getParameter( CHAMP_MODE_PAIEMENT );
    // String statutPaiement = request.getParameter( CHAMP_STATUT_PAIEMENT );
    // String modeLivraison = request.getParameter( CHAMP_MODE_LIVRAISON );
    // String statutLivraison = request.getParameter( CHAMP_STATUT_LIVRAISON );
    //
    // String message;
    // boolean erreur;
    // /*
    // * Initialisation du message à afficher : si un des champs obligatoires
    // * du formulaire n'est pas renseigné, alors on affiche un message
    // * d'erreur, sinon on affiche un message de succès
    // */
    // if ( nom.trim().isEmpty() || adresse.trim().isEmpty() ||
    // telephone.trim().isEmpty() || montant == -1
    // || modePaiement.isEmpty() || modeLivraison.isEmpty() ) {
    // // if ( nom == null || adresse== null || telephone== null || montant
    // // == -1
    // // || modePaiement== null || modeLivraison== null ) {
    // message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.
    // <br> <a href=\"creerCommande.jsp\"> Cliquez ici </a> pour accéder au
    // formulaire de création d'une commande.";
    // erreur = true;
    // } else {
    // message = "Commande créée avec succès !";
    // erreur = false;
    // }
    // /*
    // * Création des beans Client et Commande et initialisation avec les
    // * données récupérées
    // */
    //
    // Client client = new Client();
    //
    // client.setNomClient( nom );
    // client.setPrenomClient( prenom );
    // client.setAdresseClient( adresse );
    // client.setTelephoneClient( telephone );
    // client.setEmailClient( email );
    //
    // // Creation de la vine commande
    //
    // Commande commande = new Commande();
    //
    // commande.setClient( client );
    // commande.setDate( date );
    // commande.setMontantCommande( montant );
    // commande.setModePaiementCommande( modePaiement );
    // commande.setStatutLivraisonCommande( statutLivraison );
    // commande.setModeLivraisonCommande( modeLivraison );
    // commande.setStatutPaiementCommande( statutPaiement );
    //
    // /* Ajout du bean et du message à l'objet requête */
    // request.setAttribute( ATT_COMMANDE, commande );
    // request.setAttribute( ATT_MESSAGE, message );
    // request.setAttribute( ATT_ERREUR, erreur );
    //
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

}
