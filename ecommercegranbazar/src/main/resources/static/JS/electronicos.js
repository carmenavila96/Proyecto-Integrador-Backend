

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

        let contenedorCardElectro = document.getElementById("cardsFormElectro");


    result.forEach((item) => {
    
        
    let card = '<div class="card" style="width: 18rem; border: none;">\n' +
            '    <img src="'+item.imagen +'" class="card-img-top" style="object-fit:contain;width:100%; height:16rem;padding:1rem" alt="image">\n' +
            '    <div class="card-body">\n' +
            '        <hr>\n'+
            '        <h5 class="card-title">'+item.nombre+'</h5>\n' +
            '        <p class="card-text">'+item.categoria+'</p>\n' +
            '        <p class="card-text">'+'$ ' +item.precio+'</p>\n' +
            '        </div>\n' +
            '        <div class="btn-group row g-2 p-3">\n'+
            '        <a id="btnCarritoCard" href="../../carrito.html"" class="btn"><strong>Añadir al carrito</strong></a>\n'+
            '        <a id="btnComprarCard" href="../../compra.html" class="btn"><strong>Comprar</strong></a>\n'+
            '        </div>\n'+
            '</div>\n' +
            '<br/>\n';
            
              
            if(item.categoria == "Electrónicos"){ //nombre traído del option value para electrónicos en el formulario vendedores de HTML
            contenedorCardElectro.insertAdjacentHTML("beforeend",card);
            } //ifcategoria
            
     });//forEach
 }//if


}//createCards








   