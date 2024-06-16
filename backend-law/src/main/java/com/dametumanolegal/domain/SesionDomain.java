package com.dametumanolegal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SesionDomain {
    private Long idSesion;
    private String fechaSesion;
    private boolean estadoSesion;

    private StaffLegalDomain fkStaffLegal;
}
