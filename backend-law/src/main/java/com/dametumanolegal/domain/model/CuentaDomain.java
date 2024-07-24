package com.dametumanolegal.domain.model;

import lombok.*;

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
