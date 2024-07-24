package com.dametumanolegal.infrastructure.rest.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SesionRequest{
    private Long idSesion;
    private String fechaSesion;
    private boolean estadoSesion;

    private StaffLegalRequest fkStaffLegal;
    //private Long idCuenta;
}
