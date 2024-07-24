package com.dametumanolegal.infrastructure.rest.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassRequest{
    private SesionRequest sesionRequest;
    private CuentaRequest cuentaRequest;
    private String newPass;
}
