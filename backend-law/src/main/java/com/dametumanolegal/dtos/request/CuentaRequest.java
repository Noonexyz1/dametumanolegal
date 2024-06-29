package com.dametumanolegal.dtos.request;

public record CuentaRequest(
    Long id,
    String ciUsuario,
    String passUsuario,
    boolean isActive
){}
