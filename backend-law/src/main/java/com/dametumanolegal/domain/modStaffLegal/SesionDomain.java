package com.dametumanolegal.domain.modStaffLegal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SesionDomain {
    private Long idSesion;
    private String fechaSesion;
    private boolean estadoSesion;

    private StaffLegalDomain idStaffLegal;
}
