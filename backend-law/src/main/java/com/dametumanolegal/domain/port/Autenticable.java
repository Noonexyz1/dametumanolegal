package com.dametumanolegal.domain.port;

import com.dametumanolegal.request.InitSesionRequest;
import com.dametumanolegal.response.InitSesionResponse;

public interface Autenticable {
    InitSesionResponse iniciarSesion(InitSesionRequest initSesion);
    InitSesionResponse cerrarSesion(InitSesionRequest initSesion);
    InitSesionResponse modificarPassword(InitSesionResponse initSesion);
}
