package com.dametumanolegal.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolRequest {
    private Long idRol;
    private String nombreRol;
    private String descripcionRol;
    private boolean isActive;
}
