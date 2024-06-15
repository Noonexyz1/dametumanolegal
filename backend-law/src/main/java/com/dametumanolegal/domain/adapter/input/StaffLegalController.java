package com.dametumanolegal.domain.adapter.input;

import com.dametumanolegal.domain.CuentaDomain;
import com.dametumanolegal.domain.SesionDomain;
import com.dametumanolegal.domain.StaffLegalDomain;
import com.dametumanolegal.domain.port.input.Autenticable;
import com.dametumanolegal.dtos.request.CuentaRequest;
import com.dametumanolegal.dtos.request.SesionChangePassRequest;
import com.dametumanolegal.dtos.request.SesionRequest;
import com.dametumanolegal.dtos.response.SesionResponse;
import com.dametumanolegal.dtos.response.StaffLegalResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/modStaffLegal")
public class StaffLegalController {
    @Autowired //para recibir la injeccion
    private Autenticable autenticable;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/inicioSesion")
    public SesionResponse iniciarSesion(@RequestBody CuentaRequest cuentaRequest) {
        //Aqui estoy usando el port de mi dominio
        CuentaDomain cuentaDomain = modelMapper.map(cuentaRequest, CuentaDomain.class);
        SesionDomain sesionDomain = autenticable.iniciarSesion(cuentaDomain);
        SesionResponse abc = modelMapper.map(sesionDomain, SesionResponse.class);
        abc.setIdStaffLegal(modelMapper.map(sesionDomain.getFk(), StaffLegalResponse.class));
        return abc;
    }

    @PostMapping("/cerrarSesion")
    public void cerrarSesion(@RequestBody SesionRequest sesionRequest) {
        SesionDomain sesionDomain = modelMapper.map(sesionRequest, SesionDomain.class);
        StaffLegalDomain staffLegalDomain = modelMapper.map(sesionRequest.getIdStaffLegal(), StaffLegalDomain.class);
        sesionDomain.setFk(staffLegalDomain);
        autenticable.cerrarSesion(sesionDomain);
    }

    @PostMapping("/cambiarPass")
    public void modificarPassword(@RequestBody SesionChangePassRequest sesionChangePassRequest) {
        SesionDomain sesionDomain = modelMapper.map(sesionChangePassRequest, SesionDomain.class);
        StaffLegalDomain staffLegalDomain = modelMapper.map(sesionChangePassRequest.getIdStaffLegal(), StaffLegalDomain.class);
        CuentaDomain cuentaDomain = modelMapper.map(sesionChangePassRequest.getCuentaRequest(), CuentaDomain.class);
        String newPass = sesionChangePassRequest.getNewPass();
        sesionDomain.setFk(staffLegalDomain);
        autenticable.modificarPassword(sesionDomain, cuentaDomain, newPass);
    }
}
