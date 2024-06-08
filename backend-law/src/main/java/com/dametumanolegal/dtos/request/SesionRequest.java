package com.dametumanolegal.dtos.request;

import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SesionRequest {
    private Long idSesion;
    private String fechaSesion;
    private boolean estadoSesion;

    private StaffLegalDomain idStaffLegal;
}
