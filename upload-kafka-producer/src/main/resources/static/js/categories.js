function editCategory(idCategory) {
	location.href="editCategory?id=" + idCategory;
}

function deleteCategory(idCategory) {
	if (confirm("¿Está seguro que desea eliminar el registro?")) {
		location.href="deleteCategory?id=" + idCategory;
	}
}

function validateCategory() {
	f = $('form[name="categoryForm"]');		
	
	if ($('#name').val().trim() == "") {
		alert("Ingrese nombre de la categoría");
		$('#name').focus();
		return false;		
	}
	else {
		$('#name').val($('#name').val().trim());
	}	
		
	var alphaNumericRegex = /^[0-9a-zA-ZáéíóúÁÉÍÓÚ:. ]+$/;
    if (!alphaNumericRegex.test($('#name').val().trim())) {
    	alert("El campo Descripción solo acepta letras y números");
		$('#name').focus();
		return false;		    	
    }	
	
	f.submit();
}

function validateCategoryEdition() {
	f = $('form[name="categoryForm"]');		
	
	if ($('#name').val().trim() == "") {
		alert("Ingrese nombre de la categoría");
		$('#name').focus();
		return false;		
	}
	else {
		$('#name').val($('#name').val().trim());
	}	
		
	var alphaNumericRegex = /^[0-9a-zA-ZáéíóúÁÉÍÓÚ:. ]+$/;
    if (!alphaNumericRegex.test($('#name').val().trim())) {
    	alert("El campo Descripción solo acepta letras y números");
		$('#name').focus();
		return false;		    	
    }
	
	f.submit();
}

