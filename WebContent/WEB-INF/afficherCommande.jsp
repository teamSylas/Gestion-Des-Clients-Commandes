<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/inc/menu.jsp"></c:import>
<br>
<%-- <jsp:useBean id="commande" class="com.sylas.tp.beans.Commande" scope="request"></jsp:useBean>--%>
<div class="form-style-10">
<div class="inner-wrap">
	<div id="corps">
            <p class="info">${ form.resultat }</p>
            <p>Client</p>
            <p>Nom : <c:out value="${ commande.client.nomClient }"/></p>
            <p>Prénom : <c:out value="${ commande.client.prenomClient }"/></p>
            <p>Adresse : <c:out value="${ commande.client.adresseClient }"/></p>
            <p>Numéro de téléphone : <c:out value="${ commande.client.telephoneClient }"/></p>
            <p>Email : <c:out value="${ commande.client.emailClient }"/></p>
            <p>Commande</p>
            <p>Date  : <c:out value="${ commande.date }"/></p> 
            <p>Montant  : <c:out value="${ commande.montantCommande }"/></p> 
            <p>Mode de paiement  : <c:out value="${ commande.modePaiementCommande }"/></p> 
            <p>Statut du paiement  : <c:out value="${ commande.statutPaiementCommande }"/></p> 
            <p>Mode de livraison  : <c:out value="${ commande.modeLivraisonCommande }"/></p> 
            <p>Statut de la livraison  : <c:out value="${ commande.statutLivraisonCommande }"/></p> 
        </div>
	</div>
	</div>
	<%-- <p>
		==> ${commande.nomClient}; <br>
	</p --%>
	
	<%-- Affichage de la chaîne "message" transmise par la servlet --%>
	
        <%-- <p class="info"><c:out value="${ message }" escapeXml="false"></c:out>
        </p>
        <c:if test="${! erreur }">
        Puis affichage des données enregistrées dans le bean "commande" transmis par la servlet
        <p>Client</p>
        Les 5 expressions suivantes accèdent aux propriétés du client, qui est lui-même une propriété du bean commande
        <p>Nom : <c:out value="${ commande.client.nomClient }"></c:out>
        </p>
        <p>Prénom : <c:out value="${ commande.client.prenomClient }"></c:out> 
        </p>
        <p>Adresse : <c:out value=" ${ commande.client.adresseClient }"></c:out>
        </p>
        <p>Numéro de téléphone : <c:out value="${ commande.client.telephoneClient }"></c:out>
        </p>
        <p>Email : <c:out value="${ commande.client.emailClient }"></c:out>
        </p>
        <p>Commande</p>
        <p>Date  : <c:out value="${ commande.date }"></c:out>
        </p> 
        <p>Montant  : <c:out value="${commande.montantCommande }"></c:out>
        </p> 
        <p>Mode de paiement  : <c:out value=" ${commande.modePaiementCommande}"></c:out>
       </p> 
        <p>Statut du paiement  : <c:out value=" ${ commande.statutPaiementCommande}"></c:out>
       </p> 
        <p>Mode de livraison  : <c:out value="${ commande.modeLivraisonCommande }"></c:out>
        </p> 
        <p>Statut de la livraison  : <c:out value="${ commande.statutLivraisonCommande}"></c:out>
        </p> 
        </c:if> --%>
</body>
</html>