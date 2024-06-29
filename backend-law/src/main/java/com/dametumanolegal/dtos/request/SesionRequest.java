package com.dametumanolegal.dtos.request;

public record SesionRequest(
    Long idSesion,
    String fechaSesion,
    boolean estadoSesion,
    StaffLegalRequest fkStaffLegal
){}
