package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SesionDomain {
    private Long idSesion;
    private String fechaSesion;
    private boolean estadoSesion;

    private StaffLegalDomain fkStaffLegal;
    private CuentaDomain fkCuenta;
}
