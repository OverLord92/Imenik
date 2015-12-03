<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	<jsp:include page="/jspFragments/header.jsp" />
	
	<div class="container">
	<center><h3>Prijavi se</h3></center>
		<form id="login-form" action = "LoginServlet" class="form-horizontal" method = "post">
			<div class="form-group">
				<label for="userName" class="col-sm-2 control-label">Korisnicko ime</label>
				<div class="col-sm-10">
					<input name="userName" class="form-control" id="userName"
						placeholder = "unesite vase korisnicko ime" value="${existingUser}">
				</div>
			</div>
			
			<div class="form-group">
				<label for="userPassword" class="col-sm-2 control-label">Sifra</label>
				<div class="col-sm-10">
						<input type = "password" name="userPassword" class="form-control" id="userPassword"
							placeholder = "unesite sifru">
				</div>
			</div>
		<br>
			<center><button id="submit-button" type="submit" class="btn btn-dafault">Prijavi se</button></center>
		</form>
	</div>
	
	<br><br>
	<hr>
	<br>
	
	
	<div class="container">
	<center><h3>Ukoliko niste registrovani klinite na </h3></center>
	<br>
			<center><a href = "register.jsp" class="btn btn-primary">register se</a></center>
	</div>
	
	<br><br>

	<jsp:include page="/jspFragments/footer.jsp" />

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