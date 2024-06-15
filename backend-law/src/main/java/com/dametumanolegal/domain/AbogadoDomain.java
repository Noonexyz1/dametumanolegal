package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.output.ModAdmin;
import com.dametumanolegal.domain.port.input.Cuentable;

//Esta clase se encarga de parsear entradas de TIPOS o ATRIBUTOS a ENTIDADES DE DOMINIO
//y hacer la operacion de devolver de ENTIDADES DE DOMINIO a TIPOS como respuesta

public class AbogadoDomain implements Cuentable{
    private Long idAbogado;
    private boolean isAdmin;
    private StaffLegalDomain idStaffLegal;

    private ModAdmin modAdmin;

    public AbogadoDomain(ModAdmin modAdmin){
        this.modAdmin = modAdmin;
    }

    @Override
    public void crearCuentaParaStaff(CuentaDomain crearCuenta) {
        CuentaDomain cuentaDomain = CuentaDomain.builder()
                .ciUsuario(crearCuenta.getCiUsuario())
                .passUsuario(crearCuenta.getPassUsuario())
                .isActive(crearCuenta.isActive())
                .build();
        modAdmin.crearCuentaParaStaff(cuentaDomain);
    }

    @Override
    public CuentaDomain traerCuentaPorId(Long idCuenta) {
        CuentaDomain cuentaDomain = modAdmin.traerCuentaPorID(idCuenta);
        if (cuentaDomain == null) {
            return null;
        }
        cuentaDomain.setPassUsuario(null);
        return cuentaDomain;
    }

    @Override
    public void desactivarCuentaDeStaff(Long idCuenta) {
        CuentaDomain cuentaDomain = modAdmin.traerCuentaPorID(idCuenta);
        cuentaDomain.setActive(false);
        modAdmin.crearCuentaParaStaff(cuentaDomain);
    }

    @Override
    public void modifiPassCuentaDeStaff(CuentaDomain request) {
        CuentaDomain cuentaDomain = modAdmin.traerCuentaPorID(request.getIdCuenta());
        cuentaDomain.setPassUsuario(request.getPassUsuario());
        modAdmin.crearCuentaParaStaff(cuentaDomain);
    }
}
