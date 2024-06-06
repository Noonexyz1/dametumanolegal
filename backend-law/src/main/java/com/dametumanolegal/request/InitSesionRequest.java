package com.dametumanolegal.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InitSesionRequest {
    private String ciUser;
    private String passUser;
}
