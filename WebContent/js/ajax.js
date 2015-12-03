$(document).ready(function(){
		$('input').blur(function(event){
			var ID = event.target.id;
			
			var userName = $('#userName').val();
			var userEmailAddress = $('#userEmailAddress').val();
			
			$.ajax({
				url: 'AJAXCheckIfUserExists',
				method: 'GET',
				data: {ID: ID,
					userName: userName,
					userEmailAddress: userEmailAddress}
			}).done(function(odgovor){
				if(ID == 'userName'){
					$('#spanime').html(odgovor);
				}
			});
		});
});