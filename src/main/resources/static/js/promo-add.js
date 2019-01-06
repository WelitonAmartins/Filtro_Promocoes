// funcao para capturar as metatags

$("#linkPromocao").on('change', function(){
	var url = $(this).val();
	
	if(url.length > 7){
		$.ajax({
			method:"POST",
			url:"/meta/info?url=" + url,
			cache: false,
			beforeSend: function() {
				$("#alert").removeClass("alert alert-danger").text("");
				$("#title").val("");
				$("#site").text("");
				$("#linkImagem").attr("src", "");
			},
			success: function( data ) {
				console.log(data);
				$("#titulo").val(data.title);
				$("#site").text(data.site.replace("@", ""));
				$("#linkImagem").attr("src", data.image);
			},
			statusCode: {
				404: function() {
					$("#alert").addClass("alert alert-danger").text("Nenhuma informação pode ser recuperada dessa url.");
				}
			},
			error: function() {
				$("#alert").addClass("alert alert-danger").text("Ops ... Algo deu errado, tente novamente mais tarde.");
			}
		});
	}
});
