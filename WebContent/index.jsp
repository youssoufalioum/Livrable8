<%@page import="com.objis.cameroun.Rexam.domaine.Eleve"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
		<title>Rexam: Votre babillard numérique</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
	    <link rel="stylesheet" href="css/style.css">
	    <link rel="stylesheet" href="css/animate.css">
	    <script src="js/sweetalert2.js"></script>
	    <link rel="stylesheet" href="css/sweetalert2.css">
	    
       
	</head>

	<body style="background-image: linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)),url(img/p1.jpg);">

		<header>
			<div class="logo">
				<a href="index.html"><B>Rexam</B></a>
			</div>
			<div class="saisie_matricule">
				<form action="GetEleveParMtServlet" method="post" class="consulter-form">
					<input type="text" name="matricule" id="matricule" required placeholder="Saisissez votre Matricule">
					<button id="valider"><B>Consulter</B></button>
				</form>
		    </div>
		    <div class="langues">
		    <select name="langue" id="langue">
                <option value="français">Français</option>
                <option value="anglais">Anglais</option>
            </select>
        </div>
		</header>
		
		
		
		
		<%
		
		Eleve eleve =(Eleve)request.getAttribute("eleve");
		
		if(eleve!=null){
		out.println("<div id=\"bg-modal\" class=\"bg-modal\">"+
	"<div class=\"modal-contents animated bounceInDown\">"+

		 "<div class=\"close\">"+"+"+"</div>"+

		
			"<div class=\"container\">"+
		"<table class=\"table table-bordered\">"+
  "<thead>"+
    "<tr>"+
      "<th scope=\"col\">"+"Static"+"</th>"+
      "<th scope=\"col\">"+"Dynamic"+"</th>"+
    "</tr>"+
  "</thead>"+
  "<tbody>"+
    "<tr>"+
      "<th scope=\"row\">"+"Matricule"+"</th>"+
      "<td>"+eleve.getMatricule()+"</td>"+
    "</tr>"+
    "<tr>"+
      "<th scope=\"row\">"+"Nom et Prenom"+"</th>"+
      "<td>"+eleve.getNomprenom()+"</td>"+
    "</tr>"+
    "<tr>"+
      "<th scope=\"row\">"+"Date de Naissance"+"</th>"+
      "<td>"+eleve.getDatenaissance()+"</td>"+
    "</tr>"+
    "<tr>"+
      "<th scope=\"row\">"+"Lieu de Naissance"+"</th>"+
      "<td>"+eleve.getLieunaissance()+"</td>"+
    "</tr>"+
    "<tr>"+
      "<th scope=\"row\">"+"Serie"+"</th>"+
      "<td>"+eleve.getSerie()+"</td>"+
    "</tr>"+
    "<tr>"+
      "<th scope=\"row\">"+"Décision du jury"+"</th>"+
      "<td style=\"color: rgb(15,125,2);\">"+eleve.getDecisionjuge()+"</td>"+
    "</tr>"+
   
  "</tbody>"+
"</table>"+
	"</div>"+

	"</div>"+
    "</div>");
		}
    
		out.println("<script>"+
		"document.querySelector('#bg-modal').style.display = \"flex\";"+
		"</script>");
	%>	
		
		
	<script>
			
	document.querySelector('.close').addEventListener("click", function() {
	document.querySelector('#bg-modal').style.display = "none";
	});

	</script>
    
		
		
		

		<div class="accueil-rexam">
		<div class="form">
			<h2>ABONNEMENT</h2>
			<br>
			<form action="AddAbonnesServlet" method="post" class="abonnement-form">
				<p><B>Matricule</B></p>
				<input type="text" required placeholder="Votre Matricule" id="matricule" name="matricule">
				<p><B>Téléphone</B></p>
				<input type="tel" required placeholder="Votre Numéro de Téléphone" id="telephone" name="telephone">
				<br>
				<br>
				<button><B>S'abonner</B></button>
			</form>
		</div>
	</div>
	
	<%
	Integer statuts = (Integer) request.getAttribute("addSuccess");
	
	if(statuts!=null){
		
	
	
	if(statuts.intValue()==1){

		out.println("<script type=\"text/javascript\">"+
				"swal(  'Abonnement reussi!', 'vous recevrez un SMS dès la sortie du résultat', 'success');"+
		"</script>");
	} else{
		out.println("<script type=\"text/javascript\">"+
				"swal(  'Echec de Abonnement!', 'v', 'warning');"+
		"</script>");
	}
	
	
	}
	%>
	
	
	
	
	
    
    
	
    
	
	
	
	
	
	  

	<footer>
		<div class="copyright">
			<p><B>&copy 2018 Copyright. All Right Reserved</B></p>
		</div>
	</footer>

	</body>
</html>