<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*"%>
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
		<form name="uploadForm" action="UploadPicture" method="POST"
			enctype="multipart/form-data">
			<br> <br>
			<div class="form-group">
				<div class="col-sm-3"></div>

				<label for="exampleInputFile" class="col-sm-4 control-label">Klikom
					na Browse moze dodati svoju sliku</label>

				<div class="col-sm-5">
					<input type="file" name="file" id="exampleInputFile">
				</div>
				<br> <br>

			</div>

			<center>
				<button type="submit" class="btn btn-danger">Upload sliku</button>
				<a href="imena.jsp" class="btn btn-primary">Cancel</a>
			</center>
		</form>
	</div>



	<br>
	<br>
	<hr>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>


</body>
</html>