package com.dametumanolegal.domain.modAdmin;

import com.dametumanolegal.domain.port.output.ModAdmin;
import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import com.dametumanolegal.domain.port.input.Cuentable;
import com.dametumanolegal.domain.port.input.Rolable;

import java.time.LocalDateTime;
import java.util.List;

    //Esta clase se encarga de parsear entradas de TIPOS o ATRIBUTOS a ENTIDADES DE DOMINIO
    //y hacer la operacion de devolver de ENTIDADES DE DOMINIO a TIPOS como respuesta

public class AbogadoDomain implements Cuentable, Rolable {
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




    @Override
    public void crearRol(RolDomain rolNuevo) {
        modAdmin.crearRol(rolNuevo);
    }

    @Override
    public RolDomain traerRolPorId(Long id) {
        return modAdmin.traerRolPorId(id);
    }

    @Override
    public void modificarRol(RolDomain rolModificado) {
        modAdmin.modificarRol(rolModificado);
    }

    @Override
    public List<RolDomain> listarRoles() {
        return modAdmin.listarRoles();
    }

    @Override
    public void desactivarRol(RolDomain rolDesactivado) {
        rolDesactivado.setActive(false);
        modAdmin.desactivarRol(rolDesactivado);
    }

    @Override
    public void asiginarElRol(Long idPersonal, Long idRol) {
        StaffLegalDomain staffLegalDomain = modAdmin.traerStaffPorId(idPersonal);
        RolDomain rolDomain = modAdmin.traerRolPorId(idRol);

        AsignacionDomain asignacionDomain = new AsignacionDomain();
        asignacionDomain.setFechaAsignacion(LocalDateTime.now().toString());
        asignacionDomain.setActive(true);
        asignacionDomain.setIdStaffLegal(staffLegalDomain);
        asignacionDomain.setIdRol(rolDomain);

        modAdmin.asiginarElRol(asignacionDomain);
    }
}
