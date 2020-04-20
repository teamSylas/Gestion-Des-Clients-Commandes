<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link type="text/css" rel="stylesheet" href="inc/style.css" /> -->
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style2.css"/>" />
<title>Insert title here</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="<c:url value="/afficherClient"/>">Creer un nouveau client</a></li>
			<li><a href="<c:url value="/afficherCommande"/>">Creer une nouvelle commande</a></li>
			<li><a href="<c:url value="/listeClients"/>">Liste des clients</a></li>
			<li><a href="<c:url value="/listeCommandes"/>">Liste des commandes</a></li>
		</ul>
	</nav>
</body>
</html>