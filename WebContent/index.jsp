<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online imenik</title>
		<meta name = "viewport" content = "width=device-width, initial-scale=1.0">
		<link href = "css/bootstrap.min.css" rel = "stylesheet">
		<link href = "css/styles.css" rel = "stylesheet">
</head>
<body>
	
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<a href="#" class="navbar-brand">Senjinov online imenik</a>
				
				<button class="navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse">
					<span class = "icon-bar"></span>
					<span class = "icon-bar"></span>
					<span class = "icon-bar"></span>
				</button>
				
				<div class = "collapse navbar-collapse navHeaderCollapse">
					<ul class = "nav navbar-nav navbar-right">
					
						<li class="active"><a href="index.jsp">Home</a></li>
						<li><a href="#">Blog</a></li>
						<li class="dropdown">
							<a href="#" class = "dropdown-toggle" data-toggle = "dropdown">Social Media<b class = "caret"></b></a>
					
						<ul class ="dropdown-menu">
							<li><a href = "#">Twitter</a></li>
							<li><a href = "#">Facebook</a></li>
							<li><a href = "#">Instagram</a></li>
							<li><a href = "#">Google+</a></li>
						</ul>
						</li>
						<li><a href="#">About</a></li>
					
					</ul>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<div class = "container">
			<div class="jumbotron">
				<h1>Dobrodosli!</h1>
				<h2>...ili se ipak pise "dobro dosli"?</h2>
				<p>
				Ovo je moj prvi prvi "pravi" web projekat. Zamisljen je kao internet imenik. <br>
				</p>
				<ul>
				<lh>To do list:</lh>
				<li> prvo cemo omoguciti korisniku da doda svoj broj u imenik ispunjavajuci formu (27.10.), </li>
				<li> zatim cemo omoguciti korisniku da pretrazuje imenik (29.10.), </li>
				<li> zatim cemo namjestiti login i register formu (31.10.). </li>
				</ul>
				<a href="register.jsp" class = "btn btn-default">Do aplikacije<a>
				<a class = "btn btn-info">Tweer it!</a>
			</div>
		</div>
		
		<div class = "container">
			<div class="row">
					<div class="col-md-4">
						<center><h3>Koristene tehnologije:</h3></center>
						<p> 
						- JSP (Java Server Pages) <br>
						- Java Servlet <br>
						- MySql <br>
						- HTML <br>
						- CSS <br>
						- Bootstrap <br>
						</p>
					</div>
					<div class="col-md-4">
						<h3>Upozorenje</h3>
						<p> 
						Aplkacija je u fazi razvoja. Nemojte se iznenaditi ako naletite na neki dio koji ne funkcionise kako treba. U aplikaciju ce biti dodana forma koja ce omoguciti korisniku da mi posalje sve primjedbe putem maila. Posjetite moj github profil:
						</p>
						<a href="https://github.com/OverLord92" class ="btn btn-warning">github.com</a>
						
					</div>
					<div class="col-md-4">
						<h3>O BILD-IT-u?</h3>
						<p> 
						BILD-IT trening je dizajniran tako da, ukoliko radite naporno, za 10 mjeseci mozete steci potrebne vjestine i pokazati da posjedujete karakterne osobine potrebne za dobijanje posla software programera. Posjetite stranicu BILD-a: 
						</p>
						<a href="http://mozemo.ba" class ="btn btn-danger">mozemo.ba</a>
						
					</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		
		<div class = "navbar navbar-default navbar-fixed-bottom">
			<div class="container">
				<p class="navbar-text pull-left">Site Built built by Senjin Hajtulahovic</p>
				<a href = "https://www.facebook.com/senjin.hajrulahovic" class = "navbar-btn btn-primary btn pull-right">facebook profile<a>
			</div>
		</div>
		
		
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
		
		
		
		
	
		
	

</body>
</html>