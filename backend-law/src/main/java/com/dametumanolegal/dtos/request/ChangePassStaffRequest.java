package com.dametumanolegal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangePassStaffRequest {
    private CuentaRequest cuentaRequest;
    private Long idCountToChangePass;
    private String newPass;
}
