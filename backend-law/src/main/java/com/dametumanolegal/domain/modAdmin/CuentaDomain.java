package com.dametumanolegal.domain.modAdmin;

import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDomain {
    private Long idCuenta;
    private String ciUsuario;
    private String passUsuario;
    private boolean isActive;

    private StaffLegalDomain fk;
}
