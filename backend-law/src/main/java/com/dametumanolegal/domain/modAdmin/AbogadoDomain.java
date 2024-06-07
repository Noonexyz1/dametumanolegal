package com.dametumanolegal.domain.modAdmin;

import com.dametumanolegal.domain.adapter.ModAdminPersist;
import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import com.dametumanolegal.domain.port.Cuentable;
import com.dametumanolegal.domain.port.Rolable;
import com.dametumanolegal.request.CuentaRequest;
import com.dametumanolegal.response.CreateCuentaResponse;

import java.time.LocalDateTime;
import java.util.List;

//Esta clase se encarga de parsear entradas de TIPOS o ATRIBUTOS a ENTIDADES DE DOMINIO
//y hacer la operacion de devolver de ENTIDADES DE DOMINIO a TIPOS como respuesta

public class AbogadoDomain implements Cuentable, Rolable {
    private Long idAbogado;
    private boolean isAdmin;
    private StaffLegalDomain idStaffLegal;

    private final ModAdminPersist modAdminPersist;

    public AbogadoDomain(ModAdminPersist modAdminPersist){
        this.modAdminPersist = modAdminPersist;
    }

    @Override
    public void crearCuentaParaStaff(CuentaRequest request) {
        CuentaDomain cuentaDomain = CuentaDomain.builder()
                .ciUsuario(request.getCiUsuario())
                .passUsuario(request.getPassUsuario())
                .isActive(request.isActive())
                .build();
        modAdminPersist.crearCuentaParaStaff(cuentaDomain);
    }

    @Override
    public CreateCuentaResponse traerCuentaPorId(Long idCuenta) {
        var cuentaDomain = modAdminPersist.traerCuentaPorID(idCuenta);
        cuentaDomain.setPassUsuario(null);
        if (cuentaDomain == null) {
            return CreateCuentaResponse.builder()
                    .cuentaDomain(null)
                    .estado("CUENTA NO ENCONTRADA")
                    .build();
        }
        return CreateCuentaResponse.builder()
                .cuentaDomain(cuentaDomain)
                .estado("CUENTA ENCONTRADA")
                .build();
    }

    @Override
    public void desactivarCuentaDeStaff(Long idCuenta) {
        CuentaDomain cuentaDomain = modAdminPersist.traerCuentaPorID(idCuenta);
        cuentaDomain.setActive(false);
        modAdminPersist.crearCuentaParaStaff(cuentaDomain);
    }

    @Override
    public void modifiPassCuentaDeStaff(CuentaRequest request) {
        CuentaDomain cuentaDomain = modAdminPersist.traerCuentaPorID(request.getId());
        cuentaDomain.setPassUsuario(request.getPassUsuario());
        modAdminPersist.crearCuentaParaStaff(cuentaDomain);
    }



    @Override
    public void crearRol(RolDomain rolNuevo) {
        modAdminPersist.crearRol(rolNuevo);
    }

    @Override
    public RolDomain traerRolPorId(Long id) {
        return modAdminPersist.traerRolPorId(id);
    }

    @Override
    public void modificarRol(RolDomain rolModificado) {
        modAdminPersist.modificarRol(rolModificado);
    }

    @Override
    public List<RolDomain> listarRoles() {
        return modAdminPersist.listarRoles();
    }

    @Override
    public void desactivarRol(RolDomain rolDesactivado) {
        rolDesactivado.setActive(false);
        modAdminPersist.desactivarRol(rolDesactivado);
    }

    @Override
    public void asiginarElRol(Long idPersonal, Long idRol) {
        StaffLegalDomain staffLegalDomain = modAdminPersist.traerStaffPorId(idPersonal);
        RolDomain rolDomain = modAdminPersist.traerRolPorId(idRol);

        AsignacionDomain asignacionDomain = new AsignacionDomain();
        asignacionDomain.setFechaAsignacion(LocalDateTime.now().toString());
        asignacionDomain.setActive(true);
        asignacionDomain.setIdStaffLegal(staffLegalDomain);
        asignacionDomain.setIdRol(rolDomain);

        modAdminPersist.asiginarElRol(asignacionDomain);
    }
}
