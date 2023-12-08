let txtProducto = document.getElementById("inputFormProducto");
let txtCategoria = document.getElementById("inputFormCategoria");
let txtEstado = document.getElementById("inputFormEstado");
let txtDescripcion = document.getElementById("inputFormDescripcion");
let txtPrecio = document.getElementById("inputFormPrecio");
let txtTel = document.getElementById("inputFormTel");
let txtDireccion = document.getElementById("inputFormDireccion");
let txtCP = document.getElementById("inputFormCP");
let txtEnvio= document.getElementById("inputFormEnvio");


let btnEnviarForm = document.getElementById("btn-enviar-form");
let btnClear = document.getElementById("btnClear");

let terminos1 = document.getElementById("terminos1");
let terminos2 = document.getElementById("terminos2");

let alertValidaciones = document.getElementById("alertValidaciones");

let cardsForm = document.getElementById("cardsForm");


//imagen para cargar
let imagen = document.querySelector('#img-product');


function validarCategoria(){

    if (txtCategoria.value) {
        return true
    }else{
        return false;
    }
}//validarCategoria 



function validarEstado(){
    if (txtEstado.value) {
        return true
    }else{
        return false;
    }
}//validarEstado

function validarEnvio(){

    if (txtEnvio.value) {
        return true
    }else{
        return false;
    }
}//validarCategoria 


function validarPrecio(){
    if(txtPrecio.value.length ==0){
        return false;
    }//if length

    if(isNaN(txtPrecio.value)){
        return false;
    }//isNaN

    if(parseFloat(txtPrecio.value)<=0){
        return false;
    }//parseFloat

    return true;
}//ValidarPrecio

function validarTelefono(){
    let validTel = /^(?!.*(\d)\1{4})\d{10}$/;
    if(validTel.test(txtTel.value)){
        return true;
    }
    else {
        return false;
    }
}//ValidarTelefono


function validarCP() { 
    let re = /^[0-9]{5}$/;
   if (re.test(txtCP.value)){
       return true;
   }
   else {
       return false;
   }
}//validarCP

function validarTerminos1(){
    if (terminos1.checked) {
        return true
    }else{
        return false;
    }
}//validarTerminos1

function validarTerminos2(){
    if (terminos2.checked) {
        return true
    }else{
        return false;
    }
}//validarTerminos2

function validarImagen() {
    if (imagen.src.trim() === '') {
        return false;
    } else {
        return true;
    }
}//ValidarImagen


/*
// Fetch user data from the API
let promesa = fetch("http://localhost:8080/api/productos/", { method: 'GET' });



promesa
.then(response => {response.json()  
.then(result => productos = result);
})
.catch(error =>{ console.log('error en el JSON', error)
})

 .catch(
        (error)=> console.log(error, "Ocurrió un problema en la solicitud")
 );*/





btnEnviarForm.addEventListener("click", function(event){

    let isValid = true;

    event.preventDefault();
    alertValidaciones.innerHTML="";
    alertValidaciones.style.display="none";
    txtProducto.style = "";
    txtCategoria.style = "";
    txtEstado.style = "";
    txtDescripcion.style = "";
    txtPrecio.style = "";
    txtTel.style = "";
    txtDireccion.style = "";
    txtCP.style = "";
    txtEnvio.style = "";
    terminos1.style = "";
    terminos2.style = "";
    imagen.style = "";


    if(txtProducto.value.length < 3){ //Debo de indicar que quiero su value. Si la palabra tiene menos de 3 letras.
        alertValidaciones.innerHTML="El campo <strong> Producto </strong> es requerido <br/> ";
        alertValidaciones.style.display="block"; //block o inline para que lo muestre
        txtProducto.style.border = "solid thin red";//Si el campo marca un error se marcará el borde en rojo
        isValid = false;
    }//txtProducto<3


    if(! validarCategoria()){
        alertValidaciones.innerHTML+="El campo <strong> Categoría </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        txtCategoria.style.border="solid thin red";
        isValid = false;
    }//If ! validarCategoria


    if(! validarEstado()){
        alertValidaciones.innerHTML+="El campo <strong> Estado </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        txtEstado.style.border="solid thin red";
        isValid = false;
    }//If ! validarEstado


    if(! validarEnvio()){
        alertValidaciones.innerHTML+="El campo <strong> Envío </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        txtEnvio.style.border="solid thin red";
        isValid = false;
    }//If ! validarCategoria

    if(txtDescripcion.value.length < 10){ //Debo de indicar que quiero su value. Si la palabra tiene menos de 3 letras.
        alertValidaciones.innerHTML+="El campo <strong> Descripción </strong> es requerido <br/> ";
        alertValidaciones.style.display="block"; //block o inline para que lo muestre
        txtDescripcion.style.border = "solid thin red";//Si el campo marca un error se marcará el borde en rojo
        isValid = false;
    }//validar Descripción

    if(! validarPrecio()){
        alertValidaciones.innerHTML +="El campo <strong> Precio </strong> es requerido <br/> ";
        alertValidaciones.style.display="block";
        txtPrecio.style.border = "solid thin red";
        isValid = false;
    }//if ! validarCanrtidad

    if(! validarTelefono()){
        alertValidaciones.innerHTML+="El campo <strong> Teléfono </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        txtTel.style.border="solid thin red";
        isValid = false;
    }//If ! validarTelefono

    if(txtDireccion.value.length < 10){ //Debo de indicar que quiero su value. Si la palabra tiene menos de 3 letras.
        alertValidaciones.innerHTML+="El campo <strong> Dirección </strong> es requerido <br/> ";
        alertValidaciones.style.display="block"; //block o inline para que lo muestre
        txtDireccion.style.border = "solid thin red";//Si el campo marca un error se marcará el borde en rojo
        isValid = false;
    }//validar Dirección


    if(! validarCP()){
        alertValidaciones.innerHTML+="El campo <strong> Código Postal </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        txtCP.style.border="solid thin red";
        isValid = false;
    }//If ! validarCP

    if(! validarTerminos1()){
        alertValidaciones.innerHTML+="El campo <strong> Acepto los términos y condiciones </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        terminos1.style.border="solid thin red";
        isValid = false;
    }//If ! validarterminos1


    if(! validarTerminos2()){
        alertValidaciones.innerHTML+="El campo <strong> Acepto los términos de selección de productos </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        terminos2.style.border="solid thin red";
        isValid = false;
    }//If ! validarterminos1


    if (! validarImagen()){
        alertValidaciones.innerHTML+="El campo <strong> Imagen del producto </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        isValid = false;
    }//If ! validarImagen
    
    

    //JSON
    if(isValid){ //Si es valido el nombre y la cantidad los agregará a la tabla, si no, no los agregará

         var myHeaders = new Headers();
         myHeaders.append("Authorization", "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJha2FyaXNpdGFAZ21haWwuY29tIiwicm9sZSI6InVzZXIiLCJpYXQiOjE3MDIwNjY3MTEsImV4cCI6MTcwMjEwMjcxMX0.bPGjeJ05OpVieny8IFX1O0AjuN3r66Hwe-uSnenxnxI");
         myHeaders.append("Content-Type", "application/json");


            let nuevoProducto = {
               
            nombre : txtProducto.value,
            estadoProducto: txtEstado.value,
            descripcion: txtDescripcion.value,
            precio : txtPrecio.value,
            imagen:  imagen.src,
            envio: txtEnvio.value,
            categoria : txtCategoria.value,
           
               
            };

  

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: JSON.stringify(nuevoProducto),
  redirect: 'follow'
};

fetch("http://localhost:8080/api/productos/", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));


        
 
      //window.location.href = "recienanadidos.html";
      window.location.replace("recienanadidos.html");

    } //isValid


});//btnEnviar.addEventListener


//Limpiar los campos
btnClear.addEventListener("click", function(event){
    event.preventDefault();
    alertValidaciones.innerHTML="";
    alertValidaciones.style.display="none";
    txtProducto.style = "";
    txtCategoria.style = "";
    txtEstado.style = "";
    txtDescripcion.style = "";
    txtPrecio.style = "";
    txtTel.style = "";
    txtDireccion.style = "";
    txtCP.style = "";
    txtEnvio.style = "";
    terminos1.style = "";
    terminos2.style = "";

    txtProducto.value = "";
    txtCategoria.value = "";
    txtEstado.value = "";
    txtDescripcion.value = "";
    txtPrecio.value = "";
    txtTel.value = "";
    txtDireccion.value = "";
    txtCP.value= "";
    txtEnvio.value= "";
    terminos1.value = "";
    terminos2.value= "";
    

});//btnClear.addEventListener


//Boton de la imagen para cargar
let myWidget = cloudinary.createUploadWidget({
    cloudName: 'dvdf3ncs2', 
    uploadPreset: 'ElGranBazar',
    folder: 'widgetUpload', 
    cropping: true
  }, (error, result) => { 
    if (!error && result && result.event === "success") { 
        console.log('Imagen subida con éxito: ', result.info); 
        imagen.src = result.info.secure_url;
     }
});

document.getElementById("upload_widget").addEventListener("click", function(){
    myWidget.open();
  }, false);
  





/*

let txtProducto = document.getElementById("inputFormProducto");
let txtCategoria = document.getElementById("inputFormCategoria");
let txtEstado = document.getElementById("inputFormEstado");
let txtDescripcion = document.getElementById("inputFormDescripcion");
let txtPrecio = document.getElementById("inputFormPrecio");
let txtTel = document.getElementById("inputFormTel");
let txtDireccion = document.getElementById("inputFormDireccion");
let txtCP = document.getElementById("inputFormCP");
let txtEnvio= document.getElementById("inputFormEnvio");


let btnEnviarForm = document.getElementById("btn-enviar-form");
let btnClear = document.getElementById("btnClear");

let terminos1 = document.getElementById("terminos1");
let terminos2 = document.getElementById("terminos2");

let alertValidaciones = document.getElementById("alertValidaciones");

let cardsForm = document.getElementById("cardsForm");


//imagen para cargar
let imagen = document.querySelector('#img-product');


function validarCategoria(){

    if (txtCategoria.value) {
        return true
    }else{
        return false;
    }
}//validarCategoria 



function validarEstado(){
    if (txtEstado.value) {
        return true
    }else{
        return false;
    }
}//validarEstado

function validarEnvio(){

    if (txtEnvio.value) {
        return true
    }else{
        return false;
    }
}//validarCategoria 


function validarPrecio(){
    if(txtPrecio.value.length ==0){
        return false;
    }//if length

    if(isNaN(txtPrecio.value)){
        return false;
    }//isNaN

    if(parseFloat(txtPrecio.value)<=0){
        return false;
    }//parseFloat

    return true;
}//ValidarPrecio

function validarTelefono(){
    let validTel = /^(?!.*(\d)\1{4})\d{10}$/;
    if(validTel.test(txtTel.value)){
        return true;
    }
    else {
        return false;
    }
}//ValidarTelefono


function validarCP() { 
    let re = /^[0-9]{5}$/;
   if (re.test(txtCP.value)){
       return true;
   }
   else {
       return false;
   }
}//validarCP

function validarTerminos1(){
    if (terminos1.checked) {
        return true
    }else{
        return false;
    }
}//validarTerminos1

function validarTerminos2(){
    if (terminos2.checked) {
        return true
    }else{
        return false;
    }
}//validarTerminos2

function validarImagen() {
    if (imagen.src.trim() === '') {
        return false;
    } else {
        return true;
    }
}//ValidarImagen

/* ESTE ENDPOINT CON EL M´ETODO GET ES INECESARIO YA QUE ESTAMOS EN UNA P´AGINA DE POSTEO
// Fetch 
let promesa = fetch("http://localhost:8080/api/productos/", { method: 'GET' });



promesa
.then(response => {response.json()  
.then(result => productos = result);
})
.catch(error =>{ console.log('error en el JSON', error)
})

 .catch(
        (error)=> console.log(error, "Ocurrió un problema en la solicitud")
 );





btnEnviarForm.addEventListener("click", function(event){

    let isValid = true;

    event.preventDefault();
    alertValidaciones.innerHTML="";
    alertValidaciones.style.display="none";
    txtProducto.style = "";
    txtCategoria.style = "";
    txtEstado.style = "";
    txtDescripcion.style = "";
    txtPrecio.style = "";
    txtTel.style = "";
    txtDireccion.style = "";
    txtCP.style = "";
    txtEnvio.style = "";
    terminos1.style = "";
    terminos2.style = "";
    imagen.style = "";


    if(txtProducto.value.length < 3){ //Debo de indicar que quiero su value. Si la palabra tiene menos de 3 letras.
        alertValidaciones.innerHTML="El campo <strong> Producto </strong> es requerido <br/> ";
        alertValidaciones.style.display="block"; //block o inline para que lo muestre
        txtProducto.style.border = "solid thin red";//Si el campo marca un error se marcará el borde en rojo
        isValid = false;
    }//txtProducto<3


    if(! validarCategoria()){
        alertValidaciones.innerHTML+="El campo <strong> Categoría </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        txtCategoria.style.border="solid thin red";
        isValid = false;
    }//If ! validarCategoria


    if(! validarEstado()){
        alertValidaciones.innerHTML+="El campo <strong> Estado </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        txtEstado.style.border="solid thin red";
        isValid = false;
    }//If ! validarEstado


    if(! validarEnvio()){
        alertValidaciones.innerHTML+="El campo <strong> Envío </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        txtEnvio.style.border="solid thin red";
        isValid = false;
    }//If ! validarCategoria

    if(txtDescripcion.value.length < 10){ //Debo de indicar que quiero su value. Si la palabra tiene menos de 3 letras.
        alertValidaciones.innerHTML+="El campo <strong> Descripción </strong> es requerido <br/> ";
        alertValidaciones.style.display="block"; //block o inline para que lo muestre
        txtDescripcion.style.border = "solid thin red";//Si el campo marca un error se marcará el borde en rojo
        isValid = false;
    }//validar Descripción

    if(! validarPrecio()){
        alertValidaciones.innerHTML +="El campo <strong> Precio </strong> es requerido <br/> ";
        alertValidaciones.style.display="block";
        txtPrecio.style.border = "solid thin red";
        isValid = false;
    }//if ! validarCanrtidad

    if(! validarTelefono()){
        alertValidaciones.innerHTML+="El campo <strong> Teléfono </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        txtTel.style.border="solid thin red";
        isValid = false;
    }//If ! validarTelefono

    if(txtDireccion.value.length < 10){ //Debo de indicar que quiero su value. Si la palabra tiene menos de 3 letras.
        alertValidaciones.innerHTML+="El campo <strong> Dirección </strong> es requerido <br/> ";
        alertValidaciones.style.display="block"; //block o inline para que lo muestre
        txtDireccion.style.border = "solid thin red";//Si el campo marca un error se marcará el borde en rojo
        isValid = false;
    }//validar Dirección


    if(! validarCP()){
        alertValidaciones.innerHTML+="El campo <strong> Código Postal </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        txtCP.style.border="solid thin red";
        isValid = false;
    }//If ! validarCP

    if(! validarTerminos1()){
        alertValidaciones.innerHTML+="El campo <strong> Acepto los términos y condiciones </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        terminos1.style.border="solid thin red";
        isValid = false;
    }//If ! validarterminos1


    if(! validarTerminos2()){
        alertValidaciones.innerHTML+="El campo <strong> Acepto los términos de selección de productos </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        terminos2.style.border="solid thin red";
        isValid = false;
    }//If ! validarterminos1


    if (! validarImagen()){
        alertValidaciones.innerHTML+="El campo <strong> Imagen del producto </strong> es requerido <br/>";
        alertValidaciones.style.display="block";
        isValid = false;
    }//If ! validarImagen
    
    

    //JSON
    if(isValid){ //Si es valido el nombre y la cantidad los agregará a la tabla, si no, no los agregará

        var myHeaders = new Headers();
        //var myHeaders = [];
        myHeaders.append("Authorization", "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFbWlsdHkyNUBob3RtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzAxNzk2NTM1LCJleHAiOjE3MDE4MzI1MzV9.kCNm2tTW8hzNlMgDqfTHaCp_qgnWysLFYzYz1lOwOtg");
        myHeaders.append("Content-Type", "application/json");

        var raw = {
          nombre: txtProducto.value,
          estadoProducto: txtEstado.value,
          descripcion: xtDescripcion.value,
          precio: txtPrecio.value,
          imagen: imagen.src,
          envio: txtEnvio.value,
          categoria: txtCategoria.value,
        };

        var requestOptions = {
          method: 'POST',
          headers: myHeaders,
          body: JSON.stringify(raw),
          redirect: 'follow'
        };

    let promise = fetch("http://localhost:8080/api/productos/", requestOptions);

        promise
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
     
 
        window.location.href = "recienanadidos.html";

    } //isValid


});//btnEnviar.addEventListener


//Limpiar los campos
btnClear.addEventListener("click", function(event){
    event.preventDefault();
    alertValidaciones.innerHTML="";
    alertValidaciones.style.display="none";
    txtProducto.style = "";
    txtCategoria.style = "";
    txtEstado.style = "";
    txtDescripcion.style = "";
    txtPrecio.style = "";
    txtTel.style = "";
    txtDireccion.style = "";
    txtCP.style = "";
    txtEnvio.style = "";
    terminos1.style = "";
    terminos2.style = "";

    txtProducto.value = "";
    txtCategoria.value = "";
    txtEstado.value = "";
    txtDescripcion.value = "";
    txtPrecio.value = "";
    txtTel.value = "";
    txtDireccion.value = "";
    txtCP.value= "";
    txtEnvio.value= "";
    terminos1.value = "";
    terminos2.value= "";
    

});//btnClear.addEventListener


//Boton de la imagen para cargar
let myWidget = cloudinary.createUploadWidget({
    cloudName: 'dvdf3ncs2', 
    uploadPreset: 'ElGranBazar',
    folder: 'widgetUpload', 
    cropping: true
  }, (error, result) => { 
    if (!error && result && result.event === "success") { 
        console.log('Imagen subida con éxito: ', result.info); 
        imagen.src = result.info.secure_url;
     }
});

document.getElementById("upload_widget").addEventListener("click", function(){
    myWidget.open();
  }, false);
  

  */
  