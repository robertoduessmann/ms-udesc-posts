$( "#send" ).click(function() {
  send();
});


function send() {
	$('#status').html('<img src="img/loading.gif" width="40" />');

	var data = {
		message: $("#message").val()
	}
	$.ajax({
		url: "/posts",
		type: "POST",
		data: JSON.stringify(data),
		contentType: "application/json",
		complete: success
	});
}

function success(){
	 $('#status').html('Post realizado :)');
}