function validateUserLogin() {
	
	f = $('form[name="loginForm"]');
	
	if ($('#email').val().trim() == "") {
		alert("Ingrese email");
		$('#email').focus();
		return false;
	}
	else {
		$('#email').val($('#email').val().trim());
	}
	
    var regex = /[\w-\.]{2,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;
    if (!regex.test($('#email').val().trim())) {
    	alert("Email no válido");
		$('#email').focus();
		return false;		    	
    }	    
	
	if ($('#password').val().trim() == "") {
		alert("Ingrese password");
		$('#password').focus();
		return false;		
	}
	else {
		$('#password').val($('#password').val().trim());
	}	
	
	f.submit();
}