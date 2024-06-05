package com.dametumanolegal.controller;

import com.dametumanolegal.domain.port.Autenticable;
import com.dametumanolegal.request.InitSesionRequest;
import com.dametumanolegal.response.InitSesionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffLegalController implements Autenticable {
    @Autowired
    private Autenticable autenticable;

    @Override
    @PostMapping("/inicio_sesion")
    public InitSesionResponse iniciarSesion(@RequestBody InitSesionRequest initSesion) {
        //Aqui estoy usando el port de mi dominio
        return autenticable.iniciarSesion(initSesion);
    }

    @Override
    @PostMapping("/cerrar_sesion")
    public InitSesionResponse cerrarSesion(@RequestBody InitSesionRequest initSesion) {
        return autenticable.cerrarSesion(initSesion);
    }

    @Override
    @PostMapping("/cambiar_pass")
    public InitSesionResponse modificarPassword(@RequestBody InitSesionResponse initSesion) {
        return autenticable.modificarPassword(initSesion);
    }
}
