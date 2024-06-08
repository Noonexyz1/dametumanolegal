package com.dametumanolegal.dtos.response;


import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SesionResponse {
    private Long idSesion;
    private String fechaSesion;
    private boolean estadoSesion;

    private StaffLegalDomain idStaffLegal;
}
