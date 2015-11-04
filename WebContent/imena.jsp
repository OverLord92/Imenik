<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ page import="beans.User"%>
<%@ page import="beans.Contact"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online imenik</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>

<%
	HttpSession session = request.getSession();
	ArrayList<Contact> userContacts = (ArrayList<Contact>) session.getAttribute("userContacts");

	User user = (User) session.getAttribute("user");
	String linkImage = user.getLinkToImage();

	System.out.print(linkImage);
%>

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
				<a href="uploadAPic.jsp"><img src=Penguins.jpg " height="200" width="200"></a><br>
				Kliknite sliku da azurirate sliku.
			</div>
			
			<div class="col-md-9" style="padding:25px">
				<label>ime i prezime</label><br>
				<%=user.getUserName() %><br><br>
				<label>broj telefona</label><br>
				<%=user.getUserPhoneNumber() %><br><br>
				<label>mejl</label><br>
				<%=user.getUserEmailAddress() %><br><br>
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



				<%
					for (int i = 0; i < userContacts.size(); i++) {
				%>
				<tr>
					<td><%=userContacts.get(i).getContactName()%></td>
					<td><%=userContacts.get(i).getContactPhoneNumber()%></td>
					<td><%=userContacts.get(i).getEmailAddress()%></td>
				</tr>
				<%
					}
				%>

			</table>
		</div>
	</div>

	<hr>

	<div class="container">
		<center>
			<h3>Unesite novi kontakt</h3>
		</center>
		<form action="AddContact" class="form-horizontal" method="post">
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

	<div class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">
			<p class="navbar-text pull-left">Site Built built by Senjin
				Hajrulahovic</p>
			<a href="https://www.facebook.com/senjin.hajrulahovic"
				class="navbar-btn btn-primary btn pull-right">facebook profile<a>
		</div>
	</div>


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


</body>
</html>