package com.dametumanolegal.dtos.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SesionRequest {
    private Long idSesion;
    private String fechaSesion;
    private boolean estadoSesion;

    private StaffLegalRequest idStaffLegal;
}
