package com.dametumanolegal.response;

import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InitSesionResponse {
    private CuentaDomain cuentaDomain;
    private String estado;
}
