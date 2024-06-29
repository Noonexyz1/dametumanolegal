package com.dametumanolegal.domain.adapter.input;

import com.dametumanolegal.domain.CuentaDomain;
import com.dametumanolegal.domain.port.input.Cuentable;
import com.dametumanolegal.dtos.request.ChangePassStaffRequest;
import com.dametumanolegal.dtos.request.CuentaRequest;
import com.dametumanolegal.dtos.response.CuentaResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

//Esta clase se encarga de recibir entidades DTO y entregar DATOS de DOMINIO
@CrossOrigin
@RequestMapping("/modAdmin")
@RestController//ADAPTADOR de ENTRADA      //PUERTO de SALIDA de OTRO SERVICIO
public class AdminController /*implements Cuentable, Rolable*/ {

    //@Qualifier("abogadoCuentable")
    @Autowired //PUERTO DE ENTRADA a mi SERVICIO que toca adaptar
    private Cuentable cuentable;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/crearCuenta/{id}")
    public void crearCuentaParaStaff(@PathVariable Long id) {
        cuentable.crearCuentaParaStaff(id);
    }

    @GetMapping("/getCuenta/{id}")
    public CuentaResponse traerCuentaPorId(@PathVariable Long id) {
        CuentaDomain cuentaDomain = cuentable.traerCuentaPorId(id);
        return modelMapper.map(cuentaDomain, CuentaResponse.class);
    }

    @GetMapping("/descCuenta/{id}")
    public void desactivarCuentaDeStaff(@PathVariable Long id) {
        cuentable.desactivarCuentaDeStaff(id);
    }

    @PostMapping("/changeCuenta")
    public void modifiPassCuentaDeStaff(@RequestBody ChangePassStaffRequest request) {
        CuentaDomain cuentaAdmin = modelMapper.map(request.getCuentaRequest(), CuentaDomain.class);
        cuentable.modifiPassCuentaDeStaff(cuentaAdmin, request.getIdCountToChangePass(), request.getNewPass());
    }
}
