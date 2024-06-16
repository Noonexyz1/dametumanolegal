package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.output.AdminPersistence;
import com.dametumanolegal.domain.port.input.Cuentable;

//Esta clase se encarga de parsear entradas de TIPOS o ATRIBUTOS a ENTIDADES DE DOMINIO
//y hacer la operacion de devolver de ENTIDADES DE DOMINIO a TIPOS como respuesta

public class AbogadoDomain implements Cuentable{
    private Long idAbogado;
    private boolean isAdmin;
    private StaffLegalDomain fkStaffLegal;

    private AdminPersistence adminPersistence;

    public AbogadoDomain(AdminPersistence adminPersistence){
        this.adminPersistence = adminPersistence;
    }

    @Override
    public void crearCuentaParaStaff(CuentaDomain crearCuenta) {
        CuentaDomain cuentaDomain = CuentaDomain.builder()
                .ciUsuario(crearCuenta.getCiUsuario())
                .passUsuario(crearCuenta.getPassUsuario())
                .isActive(crearCuenta.isActive())
                .build();
        adminPersistence.crearCuentaParaStaff(cuentaDomain);
    }

    @Override
    public CuentaDomain traerCuentaPorId(Long idCuenta) {
        CuentaDomain cuentaDomain = adminPersistence.traerCuentaPorID(idCuenta);
        if (cuentaDomain == null) {
            return null;
        }
        cuentaDomain.setPassUsuario(null);
        return cuentaDomain;
    }

    @Override
    public void desactivarCuentaDeStaff(Long idCuenta) {
        CuentaDomain cuentaDomain = adminPersistence.traerCuentaPorID(idCuenta);
        cuentaDomain.setActive(false);
        adminPersistence.crearCuentaParaStaff(cuentaDomain);
    }

    @Override
    public void modifiPassCuentaDeStaff(CuentaDomain request) {
        CuentaDomain cuentaDomain = adminPersistence.traerCuentaPorID(request.getId());
        cuentaDomain.setPassUsuario(request.getPassUsuario());
        adminPersistence.crearCuentaParaStaff(cuentaDomain);
    }
}
