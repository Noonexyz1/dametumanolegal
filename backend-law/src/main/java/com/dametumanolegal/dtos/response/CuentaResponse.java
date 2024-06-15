package com.dametumanolegal.dtos.response;

import com.dametumanolegal.domain.StaffLegalDomain;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CuentaResponse {
    private Long idUsuario;
    private String ciUsuario;
    private String passUsuario;
    private boolean isActive;

    private StaffLegalDomain idStaffLegal;
}
