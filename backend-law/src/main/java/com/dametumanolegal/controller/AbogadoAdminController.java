package com.dametumanolegal.controller;

import com.dametumanolegal.domain.modAdmin.RolDomain;
import com.dametumanolegal.domain.port.Cuentable;
import com.dametumanolegal.domain.port.Rolable;
import com.dametumanolegal.request.CuentaRequest;
import com.dametumanolegal.request.RolRequest;
import com.dametumanolegal.request.StaffLegalRolRequest;
import com.dametumanolegal.response.CreateCuentaResponse;
import com.dametumanolegal.response.RolResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController//ADAPTADOR de ENTRADA      //PUERTO de SALIDA de OTRO SERVICIO
public class AbogadoAdminController /*implements Cuentable, Rolable*/ {

    @Autowired //PUERTO DE ENTRADA a mi SERVICIO que toca adaptar
    private Cuentable cuentable;

    @Autowired
    private Rolable rolable;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/crear_cuenta")
    public void crearCuentaParaStaff(@RequestBody CuentaRequest neuvaCuenta) {
        cuentable.crearCuentaParaStaff(neuvaCuenta);
    }

    @GetMapping("/get_cuenta_id")
    public CreateCuentaResponse traerCuentaPorId(@RequestBody Long idCuenta) {
        return cuentable.traerCuentaPorId(idCuenta);
    }

    @GetMapping("/desc_cuenta")
    public void desactivarCuentaDeStaff(@RequestBody Long idCuenta) {
        cuentable.desactivarCuentaDeStaff(idCuenta);
    }

    @PostMapping("/change_cuenta")
    public void modifiPassCuentaDeStaff(@RequestBody CuentaRequest request) {
        cuentable.modifiPassCuentaDeStaff(request);
    }



    @PostMapping("/crear_rol")
    public void crearRol(@RequestBody RolRequest request) {
        RolDomain rolDomain = modelMapper.map(request, RolDomain.class);
        rolable.crearRol(rolDomain);
    }

    @GetMapping("/find_rol")
    public RolResponse traerRolPorId(@RequestBody Long id) {
        return modelMapper.map(rolable.traerRolPorId(id), RolResponse.class);
    }

    @PostMapping("/modif_rol")
    public void modificarRol(@RequestBody RolRequest request) {
        rolable.modificarRol(modelMapper.map(request, RolDomain.class));
    }

    @GetMapping("/lista_rol")
    public List<RolDomain> listarRoles() {
        return rolable.listarRoles();
    }

    @PostMapping("/desc_rol")
    public void desactivarRol(@RequestBody RolRequest request) {
        rolable.desactivarRol(modelMapper.map(request, RolDomain.class));
    }

    @PostMapping("/asig_rol")
    public void asignarElRol(@RequestBody StaffLegalRolRequest staffLegalRolRequest) {
        rolable.asiginarElRol(staffLegalRolRequest.getIdPersonal(), staffLegalRolRequest.getIdRol());
    }
}
