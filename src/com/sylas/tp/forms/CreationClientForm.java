package com.sylas.tp.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sylas.tp.beans.Client;

public class CreationClientForm {

    public static final String  CHAMP_NOM       = "nomClient";
    public static final String  CHAMP_PRENOM    = "prenomClient";
    public static final String  CHAMP_ADRESSE   = "adresseClient";
    public static final String  CHAMP_TELEPHONE = "telephoneClient";
    public static final String  CHAMP_EMAIL     = "emailClient";

    private String              resultat;

    private Map<String, String> erreurs         = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String resultat ) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs( Map<String, String> erreurs ) {
        this.erreurs = erreurs;
    }

    public Client creerClient( HttpServletRequest request ) {

        String nom = validationChamps( request, CHAMP_NOM );
        String prenom = validationChamps( request, CHAMP_PRENOM );
        String adresse = validationChamps( request, CHAMP_ADRESSE );
        String telephone = validationChamps( request, CHAMP_TELEPHONE );
        String email = validationChamps( request, CHAMP_EMAIL );

        Client client = new Client();

        try {
            valideNom( nom );
        } catch ( Exception e ) {
            setErreurs( CHAMP_NOM, e.getMessage() );
        }
        client.setNomClient( nom );
        try {
            validePrenom( prenom );
        } catch ( Exception e ) {
            setErreurs( CHAMP_PRENOM, e.getMessage() );
        }
        client.setPrenomClient( prenom );

        try {
            valideAdresse( adresse );
        } catch ( Exception e ) {
            setErreurs( CHAMP_ADRESSE, e.getMessage() );
        }
        client.setAdresseClient( adresse );

        try {
            valideTelephone( telephone );
        } catch ( Exception e ) {
            setErreurs( CHAMP_TELEPHONE, e.getMessage() );
        }
        client.setTelephoneClient( telephone );

        try {
            valideEmail( email );
        } catch ( Exception e ) {
            setErreurs( CHAMP_EMAIL, e.getMessage() );
        }
        client.setEmailClient( email );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création du client.";
        } else {
            resultat = "Échec de la création du client.";
        }

        return client;
    }

    private void valideEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    // private void valideEmail( String email ) throws Exception {
    // if ( email != null ) {
    // if ( !email.matches( "([^.@]+)(\\\\.[^.@]+)*@([^.@]+\\\\.)+([^.@]+)" ) )
    // {
    // ;
    // throw new Exception( "Merci de saisir une adresse mail valide." );
    // } else {
    // throw new Exception( "Merci de saisir une adresse mail." );
    // }
    // }
    //
    // }

    private void valideTelephone( String telephone ) throws Exception {
        if ( telephone != null ) {
            if ( !telephone.matches( "^\\d+$" ) ) {
                throw new Exception( "Le numéro de téléphone doit uniquement contenir des chiffres." );
            } else if ( telephone.length() < 4 ) {
                throw new Exception( "Le numéro de téléphone doit contenir au moins 4 chiffres." );
            }
        } else {
            throw new Exception( "Merci d'entrer un numéro de téléphone." );
        }
    }

    private void valideAdresse( String adresse ) throws Exception {
        if ( adresse != null ) {
            if ( adresse.trim().length() < 10 ) {
                throw new Exception( "L'adresse de livraison doit contenir au moins 10 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer une adresse de livraison." );
        }
    }

    private void validePrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.trim().length() < 2 ) {
            throw new Exception( "Le prénom d'utilisateur doit contenir au moins 2 caractères." );
        }
    }

    private void valideNom( String nom ) throws Exception {
        if ( nom != null ) {
            if ( nom.trim().length() < 2 ) {
                throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un nom d'utilisateur." );
        }
    }

    private void setErreurs( String champNom, String message ) {
        // TODO Auto-generated method stub
        erreurs.put( champNom, message );

    }

    private String validationChamps( HttpServletRequest request, String nomChanp ) {
        String valeur = request.getParameter( nomChanp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
