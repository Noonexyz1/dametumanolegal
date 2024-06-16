package com.dametumanolegal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDomain {
    private Long id;
    private String ciUsuario;
    private String passUsuario;
    private boolean isActive;

    private StaffLegalDomain fkStaffLegal;
}
