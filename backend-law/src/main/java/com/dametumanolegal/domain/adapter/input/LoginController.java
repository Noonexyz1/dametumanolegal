package com.dametumanolegal.domain.adapter.input;

import com.dametumanolegal.dtos.request.CuentaRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    //vamos a retornar el objeto que es para ingresar una Cuenta
    @GetMapping
    public CuentaRequest responseToLogin(){
        //No debo poner los datos en duro, debo tener otras clase como ENUM, RECORDS o CLASES que representen estos datos
        return CuentaRequest.builder()
                .ciUsuario("Ingrese su CI") //me refiero estos datos
                .passUsuario("Ingrese su Contraseña") //me refiero estos datos
                .build();
    }
}
