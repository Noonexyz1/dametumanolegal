package com.dametumanolegal.domain.adapter.input;

import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.modAdmin.RolDomain;
import com.dametumanolegal.domain.port.input.Cuentable;
import com.dametumanolegal.domain.port.input.Rolable;
import com.dametumanolegal.dtos.request.CuentaRequest;
import com.dametumanolegal.dtos.request.RolRequest;
import com.dametumanolegal.dtos.request.StaffLegalRolRequest;
import com.dametumanolegal.dtos.response.CuentaResponse;
import com.dametumanolegal.dtos.response.RolResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/modAdmin")
@RestController//ADAPTADOR de ENTRADA      //PUERTO de SALIDA de OTRO SERVICIO
public class AdminController /*implements Cuentable, Rolable*/ {

    @Autowired //PUERTO DE ENTRADA a mi SERVICIO que toca adaptar
    @Qualifier("abogadoCuentable")
    private Cuentable cuentable;

    @Autowired
    @Qualifier("abogadoRolable")
    private Rolable rolable;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/crearCuenta")
    public void crearCuentaParaStaff(@RequestBody CuentaRequest nuevaCuentaRequest) {
        cuentable.crearCuentaParaStaff(modelMapper.map(nuevaCuentaRequest, CuentaDomain.class));
    }

    @GetMapping("/getCuentaId")
    public CuentaResponse traerCuentaPorId(@RequestBody Long idCuenta) {
        return modelMapper.map(cuentable.traerCuentaPorId(idCuenta), CuentaResponse.class);
    }

    @GetMapping("/descCuenta")
    public void desactivarCuentaDeStaff(@RequestBody Long idCuenta) {
        cuentable.desactivarCuentaDeStaff(idCuenta);
    }

    @PostMapping("/changeCuenta")
    public void modifiPassCuentaDeStaff(@RequestBody CuentaRequest request) {
        cuentable.modifiPassCuentaDeStaff(modelMapper.map(request, CuentaDomain.class));
    }



    @PostMapping("/crearRol")
    public void crearRol(@RequestBody RolRequest request) {
        RolDomain rolDomain = modelMapper.map(request, RolDomain.class);
        rolable.crearRol(rolDomain);
    }

    @GetMapping("/findRol")
    public RolResponse traerRolPorId(@RequestBody Long id) {
        return modelMapper.map(rolable.traerRolPorId(id), RolResponse.class);
    }

    @PostMapping("/modifRol")
    public void modificarRol(@RequestBody RolRequest request) {
        rolable.modificarRol(modelMapper.map(request, RolDomain.class));
    }

    @GetMapping("/listaRol")
    public List<RolResponse> listarRoles() {
        return rolable.listarRoles().stream().map(y -> modelMapper.map(y, RolResponse.class)).toList();
    }

    @PostMapping("/descRol")
    public void desactivarRol(@RequestBody RolRequest request) {
        rolable.desactivarRol(modelMapper.map(request, RolDomain.class));
    }

    @PostMapping("/asigRol")
    public void asignarElRol(@RequestBody StaffLegalRolRequest staffLegalRolRequest) {
        rolable.asiginarElRol(staffLegalRolRequest.getIdPersonal(), staffLegalRolRequest.getIdRol());
    }
}
