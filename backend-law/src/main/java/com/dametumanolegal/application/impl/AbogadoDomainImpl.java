package com.dametumanolegal.application.impl;

import com.dametumanolegal.application.port.output.AdminPersistence;
import com.dametumanolegal.domain.model.CuentaDomain;
import com.dametumanolegal.domain.model.StaffLegalDomain;
import com.dametumanolegal.domain.port.input.Cuentable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AbogadoDomainImpl implements Cuentable {

    private AdminPersistence adminPersistence;

    public AbogadoDomainImpl(AdminPersistence adminPersistence){
        this.adminPersistence = adminPersistence;
    }


    @Override
    public void crearCuentaParaStaff(Long idCuenta) {
        //traer el staff que tiene este idCuenta
        StaffLegalDomain staffLegalDomain = adminPersistence.traerStaffPorId(idCuenta);
        // ANTES de la HERENCIA
        //if (staffLegalDomain != null && staffLegalDomain.getFkFigLegal().isActive()){

        //DESPUES DE LA HERENCIA
        if (staffLegalDomain != null && staffLegalDomain.isActive()){
            //crear la cuenta con los datos de el staff legal obtenido
            CuentaDomain cuentaDomain = CuentaDomain.builder()
                    .ciUsuario(staffLegalDomain.getCi())
                    .passUsuario(staffLegalDomain.getCi())
                    .isActive(staffLegalDomain.isActive())
                    .fkStaffLegal(staffLegalDomain)
                    .build();
            adminPersistence.crearCuentaParaStaff(cuentaDomain);
        }
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
        if (cuentaDomain != null) {
            cuentaDomain.setActive(false);
            adminPersistence.crearCuentaParaStaff(cuentaDomain);
        }
    }

    @Override
    public void modifiPassCuentaDeStaff(CuentaDomain cuentaAdmin, Long idCuenta, String newPass) {
        //CuentaDomain cuentaDomainAdmin = staffLegalPersistence.buscarPorUserYPass(cuentaAdmin.getCiUsuario(), cuentaAdmin.getPassUsuario());
        //TODO
        /*CuentaDomain cuentaDomainAdmin = getStaffLegalPersistence().buscarPorUserYPass(cuentaAdmin.getCiUsuario(), cuentaAdmin.getPassUsuario());
        CuentaDomain cuentaDomainChange = adminPersistence.traerCuentaPorID(idCuenta);
        if (cuentaDomainAdmin != null && cuentaDomainChange != null) {
            cuentaDomainChange.setPassUsuario(newPass);
            adminPersistence.crearCuentaParaStaff(cuentaDomainChange);
            //PROBAR ESTE METODO
        }*/
    }
}
