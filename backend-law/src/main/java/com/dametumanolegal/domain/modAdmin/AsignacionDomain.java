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
public class AsignacionDomain {
    private Long idAsignacion;
    private String fechaAsignacion;
    private String fechaSustraccion;
    private boolean isActive;

    private StaffLegalDomain idStaffLegal;
    private RolDomain idRol;
}
