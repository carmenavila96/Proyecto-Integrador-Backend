
function getData(){

let promesa = fetch("http://localhost:8080/api/productos/", {method: 'GET'});

promesa
.then(response => {response.json()  
.then(result => createCards(result));
})
.catch(error =>{ console.log('error en el JSON', error)
})

 .catch(
        (error)=> console.log(error, "Ocurrió un problema en la solicitud")
    );

}//getData

getData();


function createCards(result){

  
if(result.length > 0) {
    let card = "";

    result.forEach((elemento) => {
        
    card += '<div class="card" style="width: 18rem; border: none;">\n' +
    '    <img src="'+elemento.imagen +'" class="card-img-top" style="object-fit:contain;width:100%; height:16rem;padding:1rem" alt="image">\n' +
    '    <div class="card-body">' +
    '        <hr>'+
    '        <h5 class="card-title">'+elemento.nombre+'</h5>\n' +
    '        <p class="card-text">'+elemento.categoria+'</p>\n' +
    '        <p class="card-text">'+'$'+elemento.precio+'</p>\n' +
    '        </div>' +
    '        <div class="btn-group row g-2 p-3">'+
    '        <a id="btnCarritoCard" href="#" class="btn"><strong>Añadir al carrito</strong></a>\n'+
    '        <a id="btnComprarCard" href="#" class="btn"><strong>Comprar</strong></a>\n'+
    '        </div>'+
    '</div>' +
    '<br/>';
});//forEach

  document.getElementById('cardsFormRecien').innerHTML = card;
} else {

  document.getElementById('cardsFormRecien').innerHTML = 'No hay información para mostrar.';
}//else

}//createCards

