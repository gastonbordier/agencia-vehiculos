console.log("Script motocicleta activado");

document.getElementById('panelAgregar').style.display = "none";
document.getElementById('panelEditarEliminar').style.display = "none";

var requestUrl = 'http://localhost:9090/motocicleta-rest/listar';



var motocicletasJson = fetch(requestUrl).then(function (response) {
	// The API call was successful!
	return response.json();

}).catch(function (err) {
	// There was an error
	console.warn('Something went wrong.', err);
});

