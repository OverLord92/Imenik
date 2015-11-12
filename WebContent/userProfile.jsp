<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ page import="beans.User"%>
<%@ page import="beans.Contact"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online imenik</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>

<body>

	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<a href="#" class="navbar-brand">Senjinov online imenik</a>

			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navHeaderCollapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<div class="collapse navbar-collapse navHeaderCollapse">
				<ul class="nav navbar-nav navbar-right">

					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="#">Blog</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Social Media<b class="caret"></b></a>

						<ul class="dropdown-menu">
							<li><a href="#">Twitter</a></li>
							<li><a href="#">Facebook</a></li>
							<li><a href="#">Instagram</a></li>
							<li><a href="#">Google+</a></li>
						</ul></li>
					<li><a href="#">About</a></li>
					<li><a href="#logOut" data-toggle="modal">Log Out</a></li>

				</ul>
			</div>
		</div>
	</div>
	
	<div class=container>
		<div class="row">
			<div class="col-md-3">
				<a href="uploadAPic.jsp"><img src="${user.linkToImage}" height="200" width="200"></a><br>
				Kliknite sliku da azurirate sliku.
			</div>
			
			<div class="col-md-9" style="padding:25px">
				<jsp:useBean id="userBean" class="beans.User" />
				<label>ime i prezime</label><br>
				${user.userName}<br>
				<label>broj telefona</label><br>
				${user.userPhoneNumber}<br>
				<label>mejl</label><br>
				${user.userEmailAddress}<br>
			</div>
		</div>
	</div>

	<br>
	<br>

	
	<div class="container">
		<div class="table-responsive">
			<table class="table">

				<tr>
					<th>Kontakt ime</th>
					<th>Kontakt broj telefona</th>
					<th>Kontakt email</th>
				</tr>

				<c:forEach items="${user.contacts}" var="element">
				<tr> 
 					<td>${element.contactName}</td>
 					<td>${element.contactPhoneNumber}</td>
 					<td>${element.emailAddress}</td> 
				</tr> 
 				</c:forEach>
 				</table>
		</div>
	</div>

	<hr>

	<div class="container">
		<center>
			<h3>Unesite novi kontakt</h3>
		</center>
		<form id="add-contact-form" action="AddContact" class="form-horizontal" method="post">
			<div class="form-group">
				<label for="userName" class="col-sm-2 control-label">Kontakt
					ime</label>
				<div class="col-sm-10">
					<input name="contactName" class="form-control" id="contactName"
						placeholder="unesite ime kontakta">
				</div>
			</div>

			<div class="form-group">
				<label for="userPassword" class="col-sm-2 control-label">Kontak
					broj telefona</label>
				<div class="col-sm-10">
					<input type="text" name="contactPhoneNumber" class="form-control"
						id="contactPhoneNumber"
						placeholder="unesite broj telefona kontakta">
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="userPassword" class="col-sm-2 control-label">Kontakt
					email</label>
				<div class="col-sm-10">
					<input type="text" name="contactEmailAddress" class="form-control"
						id="contactEmailAddress"
						placeholder="unesite email adresu kontakta">
				</div>
			</div>

			<center>
				<button type="submit" class="btn btn-dafault">Dodaj kontakt</button>
			</center>
		</form>
	</div>

	<br>
	<br>
	<br>
	<br>

	<jsp:include page="/jspFragments/footer.jsp" />
	
	<div class="modal fade" id="logOut" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4>Klikni na Log Out da bi se odjavio</h4>
				</div>
				<div class="modal-footer">
					<form action="LogOut" method="post">
					<center><button type="submit" class="btn btn-dafault">Odjavi se</button></center>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	
	<!-- 	jQuery validation -->
	<script src ="js/jquery.core.js"></script> 
	<script src="js/jquery.validate.js"></script>
	<script src="js/jquery.custom.validation.js"></script>


</body>
</html>