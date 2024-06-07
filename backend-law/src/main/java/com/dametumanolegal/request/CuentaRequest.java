package com.dametumanolegal.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CuentaRequest {
    private Long id;
    private String ciUsuario;
    private String passUsuario;
    private boolean isActive;
}
