package com.dametumanolegal.dtos.response;

import com.dametumanolegal.domain.StaffLegalDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaResponse {
    private Long id;
    private String ciUsuario;
    private String passUsuario;
    private boolean isActive;

    private StaffLegalDomain fkStaffLegal;
}
