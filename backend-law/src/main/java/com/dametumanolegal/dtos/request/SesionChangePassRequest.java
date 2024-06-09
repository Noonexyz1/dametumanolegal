package com.dametumanolegal.dtos.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SesionChangePassRequest {
    private Long idSesion;
    private String fechaSesion;
    private boolean estadoSesion;

    private StaffLegalRequest idStaffLegal;
    private CuentaRequest cuentaRequest;
    private String newPass;

}
