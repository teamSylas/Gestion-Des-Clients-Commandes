<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'un client</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css"/>" />
</head>
<body>
	<c:import url="/inc/menu.jsp"></c:import>
	<form method="post" action="<c:url value="/afficherClient"/>">
		<div class="form-style-10">
			<!-- <fieldset> -->
			<div class="section">
				<span>1</span>Informations client
			</div>
			<!-- <legend>Informations client</legend> -->
			<c:import url="/inc/client.jsp"></c:import>

			<div class="inner-wrap">
				<p class="info">${ form.resultat }</p>
			</div>

			<div class="button-section">
				<input type="submit" value="Valider" /> <input type="reset"
					value="Remettre à zéro" /> <br />
			</div>
			<!-- </div> -->
			<!-- </fieldset> -->
		</div>
	</form>
</body>
</html>