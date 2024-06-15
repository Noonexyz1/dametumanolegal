package com.dametumanolegal.domain.adapter.input;

import com.dametumanolegal.domain.CuentaDomain;
import com.dametumanolegal.domain.port.input.Cuentable;
import com.dametumanolegal.dtos.request.CuentaRequest;
import com.dametumanolegal.dtos.response.CuentaResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/modAdmin")
@RestController//ADAPTADOR de ENTRADA      //PUERTO de SALIDA de OTRO SERVICIO
public class AdminController /*implements Cuentable, Rolable*/ {

    @Autowired //PUERTO DE ENTRADA a mi SERVICIO que toca adaptar
    @Qualifier("abogadoCuentable")
    private Cuentable cuentable;

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
}
