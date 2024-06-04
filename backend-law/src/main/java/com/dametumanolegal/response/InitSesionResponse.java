package com.dametumanolegal.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InitSesionResponse {
    private String ciUser;
    private String passUser;
}
