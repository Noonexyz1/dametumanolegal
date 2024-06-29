package com.dametumanolegal.domain.adapter.input;

import com.dametumanolegal.domain.CuentaDomain;
import com.dametumanolegal.domain.SesionDomain;
import com.dametumanolegal.domain.port.input.Autenticable;
import com.dametumanolegal.dtos.request.CuentaRequest;
import com.dametumanolegal.dtos.request.ChangePassRequest;
import com.dametumanolegal.dtos.request.SesionRequest;
import com.dametumanolegal.dtos.response.SesionResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/modStaffLegal")
public class StaffLegalController {
    @Autowired //para recibir la injeccion
    @Qualifier("staffLegalModulo")
    private Autenticable autenticable;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/inicioSesion")
    public SesionResponse iniciarSesion(@RequestBody CuentaRequest cuentaRequest) {
        //Aqui estoy usando el port de mi dominio
        CuentaDomain cuentaDomain = modelMapper.map(cuentaRequest, CuentaDomain.class);
        SesionDomain sesionDomain = autenticable.iniciarSesion(cuentaDomain);
        SesionResponse abc = modelMapper.map(sesionDomain, SesionResponse.class);
        return abc;
    }

    @PostMapping("/cerrarSesion")
    public void cerrarSesion(@RequestBody SesionRequest sesionRequest) {
        SesionDomain sesionDomain = modelMapper.map(sesionRequest, SesionDomain.class);
        autenticable.cerrarSesion(sesionDomain);
    }

    @PostMapping("/cambiarPass")
    public void modificarPassword(@RequestBody ChangePassRequest changePassRequest) {
        SesionDomain sesionDomain = modelMapper.map(changePassRequest.sesionRequest(), SesionDomain.class);
        CuentaDomain cuentaDomain = modelMapper.map(changePassRequest.cuentaRequest(), CuentaDomain.class);
        String newPass = changePassRequest.newPass();
        autenticable.modificarPassword(sesionDomain, cuentaDomain, newPass);
    }
}
