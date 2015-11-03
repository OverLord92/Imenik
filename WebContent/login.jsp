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
					<li><a href="#contact" data-toggle="modal">Contact</a></li>

				</ul>
			</div>
		</div>
	</div>

	<div class="container">
	<center><h3>Prijavi se</h3></center>
		<form action = "LoginServlet" class="form-horizontal" method = "post">
			<div class="form-group">
				<label for="userName" class="col-sm-2 control-label">Korisnicko ime</label>
				<div class="col-sm-10">
					<input name="userName" class="form-control" id="userName"
						placeholder = "unesite vase korisnicko ime">
				</div>
			</div>
			
			<div class="form-group">
				<label for="userPassword" class="col-sm-2 control-label">Sifra</label>
				<div class="col-sm-10">
						<input type = "password" name="userPassword" class="form-control" id="userPassword"
							placeholder = "unesite sifru">
				</div>
			</div>
		
			<center><button type="submit" class="btn btn-dafault">Prijavi se</button></center>
		</form>
	</div>
	
	<br><br>

	<div class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">
			<p class="navbar-text pull-left">Site Built built by Senjin
				Hajrulahovic</p>
			<a href="https://www.facebook.com/senjin.hajrulahovic"
				class="navbar-btn btn-primary btn pull-right">facebook profile<a>
		</div>
	</div>


	<div class="modal fade" id="contact" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4>kontakt</h4>
				</div>
				<div class="modal-body">
					<p>tijelo mofala</p>
				</div>
				<div class="modal-footer">
					<a href="#" class="btn btn-primary" data-dismiss="modal">klouz</a>
					<a href="#" class="btn btn-default" data-dismiss="modal">klouz</a>
				</div>
			</div>
		</div>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>


</body>
</html>