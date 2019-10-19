function validateChangePassword() {
	
	f = $('form[name="changePasswordForm"]');
	
	if ($('#currentPassword').val().trim() == "") {
		alert("Ingrese password actual");
		$('#currentPassword').focus();
		return false;		
	}
	else {
		$('#currentPassword').val($('#currentPassword').val().trim());
	}
	
	if ($('#password1').val() == "") {
		alert("Ingrese nueva password");
		$('#password1').focus();
		return false;		
	}
	else {
		$('#password1').val($('#password1').val().trim());
	}	

	var alphaNumericRegex = /^[0-9a-zA-Z]+$/;
    if (!alphaNumericRegex.test($('#password1').val().trim())) {
    	alert("El campo Password solo acepta letras y números");
		$('#password1').focus();
		return false;		    	
    }	
	
	if ($('#password2').val() == "") {
		alert("Repita nueva password");
		$('#password2').focus();
		return false;		
	}
	else {
		$('#password2').val($('#password2').val().trim());
	}	
	
    if (!alphaNumericRegex.test($('#password2').val().trim())) {
    	alert("El campo Password solo acepta letras y números");
		$('#password2').focus();
		return false;		    	
    }	
	
	if ($('#password1').val() != $('#password2').val()) {
		alert("Passwords no coinciden");
		$('#password1').focus();
		return false;
	}
	
	f.submit();
}

function validateChangeSettings() {
	
	f = $('form[name="changeSettingsForm"]');
	var alphaRegex = /^[a-zA-Z ]+$/;
	
	if ($('#firstName').val().trim() == "") {
		alert("Ingrese nombres");
		$('#firstName').focus();
		return false;
	}
	else {
		$('#firstName').val($('#firstName').val().trim());
	}	
	
    if (!alphaRegex.test($('#firstName').val().trim())) {
    	alert("El campo Nombres solo acepta letras");
		$('#firstName').focus();
		return false;		    	
    }	
	
	if ($('#lastName').val().trim() == "") {
		alert("Ingrese apellidos");
		$('#lastName').focus();
		return false;		
	}
	else {
		$('#lastName').val($('#lastName').val().trim());
	}	
	
    if (!alphaRegex.test($('#lastName').val().trim())) {
    	alert("El campo Apellidos solo acepta letras");
		$('#lastName').focus();
		return false;		    	
    }
	
	f.submit();
}