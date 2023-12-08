let btnCrearCuenta = document.getElementById("btnCrearCuenta");
let btnClear = document.getElementById("btnClear");



// Fetch user data from the API
let promesa = fetch("http://localhost:8080/api/usuarios/", { method: 'GET' });

promesa
    .then(response => response.json())
    .then(result => {
        console.log(result);

   
    }) //then
    .catch(error => {
        console.log('error en el JSON', error);
    });

function validarNombre(nameInput) {
    if (nameInput) {
        return true;
    } else {
        return false;
    }
} //validarNombre

function validarCorreo(emailInput) {
    if (emailInput) {
        return true;
    } else {
        return false;
    }
} //validarEstado

function validarPassword(passwordInput) {
    if (passwordInput) {
        return true;
    } else {
        return false;
    }
} //validarPassword

function validarPasswordConf(passwd, passConf) {
    if (passwd && passwd === passConf) {
        return true;
    } else {
        return false;
    }
} //validarPassword

function validarTelefono(txtNumber) {
    let validTel = /^(?!.*(\d)\1{4})\d{10}$/;
    if (validTel.test(txtNumber)) {
        return true;
    } else {
        return false;
    }
} //ValidarTelefono

btnCrearCuenta.addEventListener("click", function (event) {
    event.preventDefault();

    const form = document.getElementById('formReg');
    form.classList.add('was-validated');

    const txtNombre = document.getElementById("InputNombreComp").value;
    const txtCorreo = document.getElementById("InputCorreo").value;
    const txtTelefono = document.getElementById("InputTelReg").value;
    const txtPassword = document.getElementById("InputPasswordReg").value;
    const txtConfPassword = document.getElementById("InputPasswordConf").value;

    let isValid = true;

    
    if (txtNombre.length < 2) {
        isValid = false;
    }

    if (!validarCorreo(txtCorreo)) {
        isValid = false;
    } //If ! validarCategoria

    if (!validarPassword(txtPassword)) {
        isValid = false;
    } //If ! validarEstado

    if (!validarPasswordConf(txtPassword, txtConfPassword)) {
        isValid = false;
    } //If ! validarCategoria

    if (!validarTelefono(txtTelefono)) {
        isValid = false;
    } //If ! validarTelefono

    // JSON
    if (isValid) {
        let nuevoUsuario = {
            email: txtCorreo,
            password: txtPassword,
        };

        let peticionPost = fetch('http://localhost:8080/api/usuarios/', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(nuevoUsuario),
        });

        peticionPost
            .then(response => response.json())
            .then(data => {
                console.log(data);
                
                Swal.fire({
                icon: "success",
                title: "Registro exitoso",
                showConfirmButton: false,
                timer: 1500
                 }); //swal
            
            })
            .catch(error => {
                console.error('Error:', error);
                
                    Swal.fire({
                icon: "error",
                title: "Oops... ",
                text: "Usuario ya registrado",
            }); //swal
            
            });
            
          
            
    }//ifisValid
    
    
    
 
}); //btnEnviar.addEventListener
