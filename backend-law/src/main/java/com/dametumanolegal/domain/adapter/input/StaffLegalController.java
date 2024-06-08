package com.dametumanolegal.domain.adapter.input;

import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.modStaffLegal.SesionDomain;
import com.dametumanolegal.domain.port.input.Autenticable;
import com.dametumanolegal.dtos.request.CuentaRequest;
import com.dametumanolegal.dtos.request.SesionRequest;
import com.dametumanolegal.dtos.response.SesionResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/modStaffLegal")
public class StaffLegalController {
    @Autowired
    private Autenticable autenticable;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/inicioSesion")
    public SesionResponse iniciarSesion(@RequestBody CuentaRequest cuentaRequest) {
        //Aqui estoy usando el port de mi dominio
        CuentaDomain cuentaDomain = modelMapper.map(cuentaRequest, CuentaDomain.class);
        SesionDomain sesionDomain = autenticable.iniciarSesion(cuentaDomain);
        return modelMapper.map(sesionDomain, SesionResponse.class);
    }

    @PostMapping("/cerrarSesion")
    public void cerrarSesion(@RequestBody SesionRequest sesionRequest) {
        autenticable.cerrarSesion(modelMapper.map(sesionRequest, SesionDomain.class));
    }

    @PostMapping("/cambiarPass")
    public void modificarPassword(@RequestBody CuentaRequest cuentaRequest) {
        autenticable.modificarPassword(modelMapper.map(cuentaRequest, CuentaDomain.class));
    }
}
