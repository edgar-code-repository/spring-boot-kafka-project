function editUser(idUser) {
	//alert("editUser: " + idUser);
	location.href="editUser?id=" + idUser;
}

function deleteUser(idUser) {
	//alert("deleteUser: " + idUser);
	if (confirm("¿Está seguro que desea eliminar el registro?")) {
		location.href="deleteUser?id=" + idUser;
	}
}

function validateUser() {
	
	f = $('form[name="userForm"]');
	
	if ($('#selectProfiles').val() == "-1") {
		alert("Indique perfil del usuario");
		$('#selectProfiles').focus();
		return false;
	}	
	
	if ($('#firstName').val().trim() == "") {
		alert("Ingrese nombres");
		$('#firstName').focus();
		return false;
	}
	else {
		$('#firstName').val($('#firstName').val().trim());
	}
	
	var alphaRegex = /^[a-zA-Z ]+$/;
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
	
	f.submit();
}

