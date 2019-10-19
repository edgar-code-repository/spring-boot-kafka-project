function cancelTicketEdition() {
	if (document.ticketForm.searchMode.value=="lastMonth") {
		month = $("#searchMonth").val();
		location.href="ticketsByMonth?searchMode=lastMonth&searchMonth=" + month;	
	}
	
	if (document.ticketForm.searchMode.value=="byMonth") {
		month = $("#searchMonth").val();
		location.href="ticketsByMonth?searchMode=byMonth&searchMonth=" + month;
	}
}

function cancelNewTicket() {
	if (document.ticketForm.searchMode.value=="lastMonth") {
		month = $("#searchMonth").val();
		location.href="ticketsByMonth?searchMode=lastMonth&searchMonth=" + month;	
	}
	
	if (document.ticketForm.searchMode.value=="byMonth") {
		month = $("#searchMonth").val();
		location.href="ticketsByMonth?searchMode=byMonth&searchMonth=" + month;
	}
	
}


function createTicket() {
	if (document.searchTicketForm.searchByMonth[0].checked) {
		month = $("#selectMonth").val();
		location.href="createTicket?searchMode=lastMonth&searchMonth=" + month;		
	}
	
	if (document.searchTicketForm.searchByMonth[1].checked) {
		month = $("#selectMonth").val();
		location.href="createTicket?searchMode=byMonth&searchMonth=" + month;
	}
	

}

function onChangeSelectMonth() {
	$("#rowTicketsTable").hide();
}

function searchTickets() {
	if (document.searchTicketForm.searchByMonth[0].checked) {
		month = $("#selectMonth").val();
		location.href="ticketsByMonth?searchMode=lastMonth&searchMonth=" + month;		
	}
	
	if (document.searchTicketForm.searchByMonth[1].checked) {
		month = $("#selectMonth").val();
		if (month == -1) {
			alert("Seleccione mes de búsqueda.");
			return false;
		}
		location.href="ticketsByMonth?searchMode=byMonth&searchMonth=" + month;		
	}
	

}

function disableMonthSelect() {
	$("#rowTicketsTable").hide();
	$("#selectMonth").val(-1);
	$("#selectMonth").prop('disabled', 'disabled');
}

function enableMonthSelect() {
	$("#rowTicketsTable").hide();
	$("#selectMonth").prop('disabled', '');
}

function editTicket(idTicket) {
	//alert("editUser: " + idUser);
	if (document.searchTicketForm.searchByMonth[0].checked) {
		location.href="editTicket?searchMode=lastMonth&searchMonth=-1&id=" + idTicket;
	}
	
	if (document.searchTicketForm.searchByMonth[1].checked) {
		month = $("#selectMonth").val();
		location.href="editTicket?searchMode=byMonth&searchMonth=" + month + "&id=" + idTicket;
	}	
}

function deleteTicket(idTicket) {
	//alert("deleteUser: " + idUser);
	if (confirm("¿Está seguro que desea eliminar el registro?")) {
		location.href="deleteTicket?id=" + idTicket;
	}
}

function onchangeSelectCategories() {
	categoryText = $('#selectCategories option:selected').text();
	$('#description').val(categoryText);
}

function validateTicket() {
	f = $('form[name="ticketForm"]');
	
	if ($('#selectUsers').val() == "-1") {
		alert("Indique técnico asignado");
		$('#selectUsers').focus();
		return false;
	}	
	
	if ($('#selectCategories').val() == "-1") {
		alert("Indique categoría del ticket");
		$('#selectCategories').focus();
		return false;
	}	
	
	if ($('#usuarioSolicitante').val().trim() == "") {
		alert("Ingrese usuario solicitante");
		$('#usuarioSolicitante').focus();
		return false;
	}
	else {
		$('#usuarioSolicitante').val($('#usuarioSolicitante').val().trim());
	}
	
	var alphaRegex = /^[a-zA-Z ]+$/;
    if (!alphaRegex.test($('#usuarioSolicitante').val().trim())) {
    	alert("El campo Usuario solicitante solo acepta letras");
		$('#usuarioSolicitante').focus();
		return false;		    	
    }		
	
	if ($('#description').val().trim() == "") {
		alert("Ingrese descripción");
		$('#description').focus();
		return false;		
	}
	else {
		$('#description').val($('#description').val().trim());
	}	
	
	/* ¿¿¿ Como considerar tildes dentro de expresion regular  ???*/
	
	var alphaNumericRegex = /^[0-9a-zA-ZáéíóúÁÉÍÓÚ:. ]+$/;
    if (!alphaNumericRegex.test($('#description').val().trim())) {
    	alert("El campo Descripción solo acepta letras y números");
		$('#description').focus();
		return false;		    	
    }	
	
	f.submit();
}

function validateTicketEdition() {
	f = $('form[name="ticketForm"]');
	
	if ($('#selectUsers').val() == "-1") {
		alert("Indique técnico asignado");
		$('#selectUsers').focus();
		return false;
	}	
	
	if ($('#selectCategories').val() == "-1") {
		alert("Indique categoría del ticket");
		$('#selectCategories').focus();
		return false;
	}
	
	if ($('#selectState').val() == "-1") {
		alert("Indique estado del ticket");
		$('#selectState').focus();
		return false;
	}
	
	if ($('#usuarioSolicitante').val().trim() == "") {
		alert("Ingrese usuario solicitante");
		$('#usuarioSolicitante').focus();
		return false;
	}
	else {
		$('#usuarioSolicitante').val($('#usuarioSolicitante').val().trim());
	}	
	
	var alphaRegex = /^[a-zA-Z ]+$/;
    if (!alphaRegex.test($('#usuarioSolicitante').val().trim())) {
    	alert("El campo Usuario solicitante solo acepta letras");
		$('#usuarioSolicitante').focus();
		return false;		    	
    }	
	
    var alphaNumericRegex = /^[0-9a-zA-Z ]+$/;
	if ($('#description').val().trim() == "") {
		alert("Ingrese descripción");
		$('#description').focus();
		return false;		
	}
	else {
		$('#description').val($('#description').val().trim());
	}	
	
	var alphaNumericRegex = /^[0-9a-zA-ZáéíóúÁÉÍÓÚ:. ]+$/;
    if (!alphaNumericRegex.test($('#description').val().trim())) {
    	alert("El campo Descripción solo acepta letras y números");
		$('#description').focus();
		return false;	    	
    }
	
	f.submit();
}
