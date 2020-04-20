<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'une commande</title>
<link type="text/css" rel="stylesheet"
	href=" <c:url value="/inc/style.css"/>" />
</head>
<body>

	<c:import url="/inc/menu.jsp"></c:import>


	<div class="form-style-10">
		<form method="post" action="<c:url value="/afficherCommande"/>">

			<div class="section">
				<span>1</span>Informations client
			</div>
			<%-- Si et seulement si la Map des clients en session n'est pas vide, alors on propose un choix à l'utilisateur --%>
			<c:if test="${ !empty sessionScope.clients }">
				<label for="choixNouveauClient">Nouveau client ? <span
					class="requis">*</span></label>
				<input type="radio" id="choixNouveauClient"
					name="choixNouveauClient" value="nouveauClient" checked /> Oui
                        <input type="radio" id="choixNouveauClient"
					name="choixNouveauClient" value="ancienClient" /> Non
                        <br />
				<br />
			</c:if>

			<c:set var="client" value="${ commande.client }" scope="request" />
			<div id="nouveauClient">
				<c:import url="/inc/client.jsp" />
			</div>

			<%-- Si et seulement si la Map des clients en session n'est pas vide, alors on crée la liste déroulante --%>
			<c:if test="${ !empty sessionScope.clients }">
				<div id="ancienClient">
					<select name="listeClients" id="listeClients">
						<option value="">Choisissez un client...</option>
						<%-- Boucle sur la map des clients --%>
						<c:forEach items="${ sessionScope.clients }" var="mapClients">
							<%--  L'expression EL ${mapClients.value} permet de cibler l'objet Client stocké en tant que valeur dans la Map, 
                                  et on cible ensuite simplement ses propriétés nom et prenom comme on le ferait avec n'importe quel bean. --%>
							<option value="${ mapClients.value.nomClient }">${ mapClients.value.prenomClient }
								${ mapClients.value.nomClient }</option>
						</c:forEach>
					</select>
				</div>
			</c:if>


			<div class="section">
				<span>2</span>Informations commande
			</div>
			<!-- <legend>Informations commande</legend> -->
			<div class="inner-wrap">
				<label for="dateCommande">Date <span class="requis">*</span>
				</label> <input type="text" id="dateCommande" name="dateCommande"
					value="${commande.date}" size="20" maxlength="20" disabled /> <span
					class="erreur">${form.erreurs['dateCommande']}</span>
			</div>
			<div class="inner-wrap">
				<label for="montantCommande">Montant <span class="requis">*</span>
				</label> <input type="text" id="montantCommande" name="montantCommande"
					value="${commande.montantCommande}" size="20" maxlength="20" /> <span
					class="erreur">${form.erreurs['montantCommande']}</span> <br />
			</div>
			<div class="inner-wrap">
				<label for="modePaiementCommande">Mode de paiement <span
					class="requis">*</span>
				</label> <input type="text" id="modePaiementCommande"
					name="modePaiementCommande"
					value="${commande.modePaiementCommande}" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['modePaiementCommande']}</span>
			</div>
			<div class="inner-wrap">
				<label for="statutPaiementCommande">Statut du paiement </label> <input
					type="text" id="statutPaiementCommande"
					name="statutPaiementCommande"
					value="${commande.statutPaiementCommande}" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['statutPaiementCommande']}</span>
			</div>
			<div class="inner-wrap">
				<label for="modeLivraisonCommande">Mode de livraison <span
					class="requis">*</span>
				</label> <input type="text" id="modeLivraisonCommande"
					name="modeLivraisonCommande"
					value="${commande.modeLivraisonCommande}" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['modeLivraisonCommande']}</span>
			</div>
			<div class="inner-wrap">
				<label for="statutLivraisonCommande">Statut de la livraison
				</label> <input type="text" id="statutLivraisonCommande"
					name="statutLivraisonCommande"
					value="${commande.statutLivraisonCommande}" size="20"
					maxlength="20" /> <span class="erreur">${form.erreurs['statutLivraisonCommande']}</span>
			</div>

			<div class="inner-wrap">
				<p class="info">${ form.resultat }</p>
			</div>
			<div class="button-section">
				<input type="submit" value="Valider" /> <input type="reset"
					value="Remettre à zéro" /> <br />
			</div>
		</form>
	</div>

	<%-- Inclusion de la bibliothèque jQuery. Vous trouverez des cours sur JavaScript et jQuery aux adresses suivantes :
               - http://www.siteduzero.com/tutoriel-3-309961-dynamisez-vos-sites-web-avec-javascript.html 
               - http://www.siteduzero.com/tutoriel-3-659477-un-site-web-dynamique-avec-jquery.html 
               
             Si vous ne souhaitez pas télécharger et ajouter jQuery à votre projet, vous pouvez utiliser la version fournie directement en ligne par Google :
             <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script> 
        --%>
	<script src="<c:url value="/inc/jquery.js"/>"></script>

	<%-- Petite fonction jQuery permettant le remplacement de la première partie du formulaire par la liste déroulante, au clic sur le bouton radio. --%>
	<script>
		jQuery(document).ready(function() {
			/* 1 - Au lancement de la page, on cache le bloc d'éléments du formulaire correspondant aux clients existants */
			$("div#ancienClient").hide();
			/* 2 - Au clic sur un des deux boutons radio "choixNouveauClient", on affiche le bloc d'éléments correspondant (nouveau ou ancien client) */
			jQuery('input[name=choixNouveauClient]:radio').click(function() {
				$("div#nouveauClient").hide();
				$("div#ancienClient").hide();
				var divId = jQuery(this).val();
				$("div#" + divId).show();
			});
		});
	</script>

	<%-- <div>
            <form method="post" action="<c:url value="/afficherCommande"/>">
             Petite astuce ici : placer le client accessible via  
                 l'EL ${ commande.client } dans une variable "client" de 
                 portée request, pour que le code du fragment fonctionne
                 à la fois depuis le formulaire de création d'un client 
                 et depuis celui de création d'une commande.
                <c:set var="client" value="${ commande.client }" scope="request" />
              <c:import url="client.jsp"></c:import>
                <fieldset>
                    <legend>Informations commande</legend>
                    
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" value="${commande.date}" size="20" maxlength="20" disabled />
                    <span class="erreur">${form.erreurs['dateCommande']}</span>
                    <br />
                    
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value="${commande.montantCommande}" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['montantCommande']}</span>
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="${commande.modePaiementCommande}" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['modePaiementCommande']}</span>
                    <br />
                    
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="${commande.statutPaiementCommande}" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['statutPaiementCommande']}</span>
                    <br />
                    
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="${commande.modeLivraisonCommande}" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['modeLivraisonCommande']}</span>
                    <br />
                    
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="${commande.statutLivraisonCommande}" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['statutLivraisonCommande']}</span>
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div> --%>
</body>
</html>