package com.dametumanolegal.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolResponse {
    private Long idRol;
    private String nombreRol;
    private String descripcionRol;
    private boolean isActive;
}
