package com.dametumanolegal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaRequest {
    private Long id;
    private String ciUsuario;
    private String passUsuario;
    private boolean isActive;
}