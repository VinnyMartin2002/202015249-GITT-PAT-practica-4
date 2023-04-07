function getRatingJugador(){
  let nombreJugador = document.getElementById('nombreJugador').value;
	return fetch("https://api.chess.com/pub/player/"+nombreJugador+"/stats")
	.then (response=>response.json())
	.then (data=>{
    var p = document.getElementById('textoRating');
    var j = document.getElementById('textoNombre');
    if(data.code==0){
      j.innerText = "El jugador que acaba de buscar...";
      p.innerText = "... no existe";
    } else if(data.chess_rapid.last.rating!=null) {
   
      p.innerText = data.chess_rapid.last.rating;
      j.innerText = nombreJugador;
    }
  })
	.catch(error => {
      console.log("Error en la solicitud: ", error);
      return null;

});
}

function init() {
  var boton = document.getElementById('get-rating-jugador');
  boton.addEventListener('click', getRatingJugador);
}

init();

