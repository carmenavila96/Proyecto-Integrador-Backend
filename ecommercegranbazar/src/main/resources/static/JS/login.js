let btnIniciarSesion = document.getElementById("btnIniciarSesion");

btnIniciarSesion.addEventListener("click", function (event) {

        event.preventDefault();

        const emailInput = document.getElementById('inputEmaillogin').value;
        const passwordInput = document.getElementById('inputPasswordlogin').value;
     
        

//Navbar si se esta logueado o no
let logArray = JSON.parse(localStorage.getItem('logArray')) || [];
let logOutorIn = false;
        
// Fetch user data from the API
        
      
var myHeaders = new Headers();
myHeaders.append("Authorization", "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFbWlsdHkyNUBob3RtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzAxNzk2NTM1LCJleHAiOjE3MDE4MzI1MzV9.kCNm2tTW8hzNlMgDqfTHaCp_qgnWysLFYzYz1lOwOtg");
myHeaders.append("Content-Type", "application/json");

var raw = {
  email: emailInput,
  password: passwordInput
};

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: JSON.stringify(raw),
  redirect: 'follow'
};

fetch("http://localhost:8080/api/login/", requestOptions)
  .then(response => response.text())
    .then(result => {console.log(result)
             
             let respuesta = JSON.parse(result);
             let acceso = respuesta.hasOwnProperty("accessToken")
            
            
            
            
        if(acceso){
        logOutorIn = true;
           
            Swal.fire({
                icon: "success",
                title: "Inicio de sesión exitoso",
                showConfirmButton: false,
                timer: 1500
            }); //swal
            
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
             Swal.fire({
                    icon: "error",
                    title: "Oops... ",
                    text: "¡El usuario no existe o las credenciales son incorrectas!, intenta nuevamente",
                });
            
            }//else
        })
  .catch(error => console.log('error', error));
});  