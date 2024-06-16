package com.dametumanolegal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangePassRequest {
    private SesionRequest sesionRequest;
    private CuentaRequest cuentaRequest;
    private String newPass;
}
