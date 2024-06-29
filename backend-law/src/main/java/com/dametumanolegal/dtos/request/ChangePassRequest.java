package com.dametumanolegal.dtos.request;

public record ChangePassRequest(
    SesionRequest sesionRequest,
    CuentaRequest cuentaRequest,
    String newPass
){}
