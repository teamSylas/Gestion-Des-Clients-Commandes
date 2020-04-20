<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <jsp:useBean id="commande" class="com.sylas.tp.beans.Commande" scope="request"></jsp:useBean>
	<p>
		==> ${commande.nomClient}; <br>
	</p> --%>
	<c:import url="/inc/menu.jsp"></c:import>
	<br>
	<%-- Affichage de la chaîne "message" transmise par la servlet --%>
<div class="form-style-10">	
<div class="inner-wrap">
	<div id="corps">
		<p class="info">${ form.resultat }</p>
		<p>
			Nom :
			<c:out value="${ client.nomClient }" />
		</p>
		<p>
			Prénom :
			<c:out value="${ client.prenomClient }" />
		</p>
		<p>
			Adresse :
			<c:out value="${ client.adresseClient }" />
		</p>
		<p>
			Numéro de téléphone :
			<c:out value="${ client.telephoneClient }" />
		</p>
		<p>
			Email :
			<c:out value="${ client.emailClient }" />
		</p>
	</div>
</div>
</div>
	<%-- <p class="info">
		
				test="${ client.nomClient == null ||  
	        	client.prenomClient == null ||client.adresseClient == null ||
	        	client.telephoneClient == null  ||
	        	client.emailClient == null}">
				<c:out value="${ form.message }" escapeXml="false"></c:out>
			<c:if test="${!form.erreurs[''] }">
				Puis affichage des données enregistrées dans le bean "client" transmis par la servlet
				<p>
					Nom :
					<c:out value="${ client.nomClient }"></c:out>
				</p>
				<p>
					Prénom :
					<c:out value="${ client.prenomClient }"></c:out>
				</p>
				<p>
					Adresse :
					<c:out value="${ client.adresseClient }"></c:out>
				</p>
				<p>
					Numéro de téléphone :
					<c:out value="${ client.telephoneClient }"></c:out>
				</p>
				<p>
					Email :
					<c:out value="${ client.emailClient }"></c:out>
				</p>
				</c:if> --%>
	<%-- </c:when>
			<c:otherwise>
				<c:out value="${ message }" escapeXml="false"></c:out>
			</c:otherwise>
		</c:choose> --%>
	<!-- </p> -->
</body>
</html>