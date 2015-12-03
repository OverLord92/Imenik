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
	
	<jsp:include page="/jspFragments/header.jsp" />
		
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
				<li> omoguciti korisniku da doda svoj broj u imenik ispunjavajuci formu (27.10.), - uradnjeno</li>
				<li> omoguciti korisniku da pretrazuje imenik (29.10.), - uradnjeno</li>
				<li> namjestiti login i register formu (31.10.) - uradnjeno</li>
				<li> <strike>korisniku omoguciti da ubaci profilnu sliku (1.11.) </strike></li>
					<ul>
						<li>Otkako sam projekat postavio na github koruptira mi slike pri upload-u</li>
					</ul>
				<li> konekcija ostvarena koristeci singleton pattern (5.11.)</li>
				<li> smanjena redundantnost koda u jsp fajlovima koristeci jsp:include tag za header i footer (6.11.)</li>
				<li> skripleti unutar JSP-ova zamjenjani EL i JSTL-om </li>
				<li> uradjena client-side validacija</li>
				<li> koristen AJAX ukoliko se pokusava resitrovati korisnik sa vec postojecim korisnickim imenom</li>
				</ul>
				<a href="login.jsp" class = "btn btn-default">Do aplikacije</a>
			</div>
		</div>
		
		<div class = "container">
			<div class="row">
					<div class="col-md-4">
						<center><h3>Koristene tehnologije:</h3></center>
						<ul> 
						<li>JSP (Java Server Pages)</li>
						<li>Java Servlet</li>
						<li>MySql</li>
						<li>HTML</li>
						<li>CSS</li>
						<li>Bootstrap</li>
						<li>jQuery Validation i UI</li>
						<li>AJAX</li>
						</ul>
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
		
		<jsp:include page="/jspFragments/footer.jsp" />
		
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
		
		
		
		
	
		
	

</body>
</html>