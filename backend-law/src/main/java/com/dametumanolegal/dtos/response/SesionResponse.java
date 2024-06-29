package com.dametumanolegal.dtos.response;

public record SesionResponse(
    Long idSesion,
    String fechaSesion,
    boolean estadoSesion,
    StaffLegalResponse fkStaffLegal
){}
