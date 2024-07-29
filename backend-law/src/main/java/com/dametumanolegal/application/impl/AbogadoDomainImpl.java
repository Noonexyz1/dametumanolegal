package com.dametumanolegal.application.impl;

import com.dametumanolegal.application.datacarries.CuentaDataCarrier;
import com.dametumanolegal.application.datacarries.StaffLegalDataCarrier;
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
        StaffLegalDataCarrier staffLegalDataCarrier = adminPersistence.traerStaffPorId(idCuenta);

        if (staffLegalDataCarrier != null && staffLegalDataCarrier.isActive()){
            CuentaDataCarrier cuentaDataCarrier = CuentaDataCarrier.builder()
                    .ciUsuario(staffLegalDataCarrier.getCi())
                    .passUsuario(staffLegalDataCarrier.getCi())
                    .isActive(staffLegalDataCarrier.isActive())
                    .fkStaffLegal(staffLegalDataCarrier)
                    .build();
            adminPersistence.crearCuentaParaStaff(cuentaDataCarrier);
        }
    }

    @Override
    public CuentaDomain traerCuentaPorId(Long idCuenta) {
        CuentaDataCarrier cuentaDataCarrier = adminPersistence.traerCuentaPorID(idCuenta);
        if (cuentaDataCarrier == null) {
            return null;
        }
        cuentaDataCarrier.setPassUsuario(null);

        /*TODO Tengo que hacer el mapeo correspondiente aqui debido a la herencia*/
        StaffLegalDomain staffLegalDomain = new StaffLegalDomain();

        CuentaDomain cuentaDomain = CuentaDomain.builder()
                .id(cuentaDataCarrier.getId())
                .ciUsuario(cuentaDataCarrier.getCiUsuario())
                .passUsuario(cuentaDataCarrier.getPassUsuario())
                .isActive(cuentaDataCarrier.isActive())
                .fkStaffLegal(staffLegalDomain)
                .build();

        return cuentaDomain;
    }

    @Override
    public void desactivarCuentaDeStaff(Long idCuenta) {
        CuentaDataCarrier cuentaDataCarrier = adminPersistence.traerCuentaPorID(idCuenta);
        if (cuentaDataCarrier != null) {
            cuentaDataCarrier.setActive(false);
            adminPersistence.crearCuentaParaStaff(cuentaDataCarrier);
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
