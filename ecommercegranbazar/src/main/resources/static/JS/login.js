let btnIniciarSesion = document.getElementById("btnIniciarSesion");

btnIniciarSesion.addEventListener("click", function (event) {

        event.preventDefault();

        const emailInput = document.getElementById('inputEmaillogin').value;
        const passwordInput = document.getElementById('inputPasswordlogin').value;
        
        
        // Fetch user data from the API
        
        
    let promesa = fetch("http://localhost:8080/api/usuarios/", { method: 'GET' });

console.log(promesa);


promesa
.then(response => {response.json()  
.then(result => {

   let usuarios = result;

   let logArray = JSON.parse(localStorage.getItem('logArray')) || [];
        let logOutorIn = false;
    
        //function logIn(){
        
        usuarios.forEach(e => { 
            
            if((e.email === emailInput) && (e.password === passwordInput)){
                logOutorIn = true;
                console.log(logOutorIn);
                
                Swal.fire({
                    //position: "top-end",
                    icon: "success",
                    title: `Bienvenid@ ${e.name}`,
                    showConfirmButton: false,
                    timer: 1500
                });

                window.location.href = 'index.html';//Redirige a Home, Si comentan esta redirección pueden observar la Swwet alert, si no es imperceptibe y envía de una a Home.
                
                if (logOutorIn){
                    //Arreglo que va a almacenar si el usuario está logIn or logOut
                    let sesion = {status: "active"}
            
                    //Ir almacenando elementos a mi array > Hace que una cadena de texto se vuelva un object
                    logArray.push((sesion));
                    //Guardar mi arreglo en el local storage
                    localStorage.setItem("logArray", JSON.stringify(logArray));
                    console.log(logArray);
                }

            }else{
                //alertValidaciones.innerHTML = "El usuario no existe o las credenciales son incorrectas.<br/>";
                //alertValidaciones.style.display = "block";
                Swal.fire({
                    icon: "error",
                    title: "Oops... ",
                    text: "¡El usuario no existe o las credenciales son incorrectas!, intenta nuevamente",
                });
            }

           
            
        })//forEach
        
        if (usuarios.length <= 0){
            //alertValidaciones.innerHTML = "El usuario no existe o las credenciales son incorrectas.<br/>";
            //alertValidaciones.style.display = "block";
            Swal.fire({
                icon: "error",
                title: "Oops... ",
                text: "¡El usuario no existe o las credenciales son incorrectas!, intenta nuevamente",
            });
        }



});

})
.catch(error =>{ console.log('error en el JSON', error)
})

 .catch(
        (error)=> console.log(error, "Ocurrió un problema en la solicitud")
  );    
        

        
        
        
 

});