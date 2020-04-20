<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
            
                <!-- <fieldset>
                    <legend>Informations client</legend> -->
    <div class="inner-wrap">
                    <label for="nomClient">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomClient" name="nomClient" value="${ client.nomClient }" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['nomClient']}</span>
                    <!-- <br /> -->
                    </div>
              
              <div class="inner-wrap">      
                    <label for="prenomClient">Prénom </label>
                    <input type="text" id="prenomClient" name="prenomClient" value="${ client.prenomClient }" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['prenomClient']}</span>
                   <!--  <br /> -->
    </div>
    <div class="inner-wrap">
                    <label for="adresseClient">Adresse de livraison <span class="requis">*</span></label>
                    <input type="text" id="adresseClient" name="adresseClient" value="${ client.adresseClient }" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['adresseClient']}</span>
                   <!--  <br /> -->
                   </div>
    <div class="inner-wrap">
                    <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
                    <input type="text" id="telephoneClient" name="telephoneClient" value="${ client.telephoneClient }" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['telephoneClient']}</span>
                   <!--  <br /> -->
                   </div>
      <div class="inner-wrap">        
                    <label for="emailClient">Adresse email</label>
                    <input type="email" id="emailClient" name="emailClient" value="${ client.emailClient }" size="20" maxlength="60" />
                    <span class="erreur">${form.erreurs['emailClient']}</span>
                   <!--  <br /> -->
                   </div>
                <!-- </fieldset> -->
                
        </div>
</body>
</html>