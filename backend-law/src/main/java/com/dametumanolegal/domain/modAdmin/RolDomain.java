package com.dametumanolegal.domain.modAdmin;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolDomain {
    private Long idRol;
    private String nombreRol;
    private String descripcionRol;
    private boolean isActive;
}
