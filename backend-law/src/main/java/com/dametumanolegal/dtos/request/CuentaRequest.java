package com.dametumanolegal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaRequest{
    //private Long id;
    private String ciUsuario;
    private String passUsuario;
    //private boolean isActive;
}
