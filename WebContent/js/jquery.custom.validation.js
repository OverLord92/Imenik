$(function(){
	
	$.validator.setDefaults({
		errorClass: 'help-block',
		highlight: function(element) {
			$(element)
				.closest('.form-group')
				.addClass('has-error');
		},
		unhighlight: function(element) {
			$(element)
				.closest('.form-group')
				.removeClass('has-error');
		}
	});
	
	$.validator.addMethod('strongPassword', function(value, element) {
		return this.optional(element)
		|| value.length >= 5
		&& /\d/.test(value)
		&& /[a-z]/i.test(value);
	}, 'Sifra mora biti duga najmanje 5 karaktera i mora sadrzati minimalno jedno slovo i minimlano jednu cifru.');
	
	

	$("#login-form").validate({
		rules: {
			userName: "required",
			userPassword: "required"
		},
		messages: {
			userName: {
				required: 'Morate upisati korisnicko ime kako bi se prijavili'
			},
			userPassword: {
				required: 'Morate upisati sifru kako bi se prijavili'
			}
		
		}
	
	});
	
	
	$("#register-form").validate({
		rules: {
			userName: "required",
			userPhoneNumber: "required",
			userEmailAddress: {
				required: true,
				email: true
			},
			userPassword:  {
				required: true,
				strongPassword: true
			},
			userPasswordConfirm: {
				required: true,
				equalTo: "#userPassword"
			}
		},
		messages: {
			userName: {
				required: 'Morate upisati svoje ime i prezime kako bi se mogli registrovati.'
			},
			userPhoneNumber: {
				required: 'Morate upisati boj telefona kako bi se registrovali.'
			},
			userEmailAddress: {
				email: 'Unesite validnu email adresu',
				required: 'Morate upisati svoju email adresu kako bi se registrovali.'
			},
			userPasswordConfirm: {
				equalTo: 'Morate unjeti dva puta istu sifru'
			}
		}
		
	});
	
	$("#add-contact-form").validate({
		rules: {
			contactName: "required",
			contactPhoneNumber: "required",
			contactEmailAddress: {
				required: true,
				email: true
			}
		},
		messages: {
			contactName: {
				required: 'Morate upisati ime kontakta'
			},
			contactPhoneNumber: {
				required: 'Morate upisati broj telefona kontakta'
			},
			contactEmailAddress: {
				required: 'Morate upisati email adresu kontakta'
			}
		}
		
	});
	
});