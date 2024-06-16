package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.output.AdminPersistence;
import com.dametumanolegal.domain.port.input.Cuentable;
import com.dametumanolegal.domain.port.output.StaffLegalPersistence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Esta clase se encarga de recibir entradas de TIPOS o ATRIBUTOS o ENTIDADES DE DOMINIO
//y hacer la operacion de devolver de ENTIDADES DE DOMINIO o TIPOS como respuesta
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbogadoDomain implements Cuentable{
    private Long idAbogado;
    private boolean isAdmin;
    private StaffLegalDomain fkStaffLegal;

    private AdminPersistence adminPersistence;
    private StaffLegalPersistence staffLegalPersistence;

    public AbogadoDomain(AdminPersistence adminPersistence, StaffLegalPersistence staffLegalPersistence){
        this.adminPersistence = adminPersistence;
        this.staffLegalPersistence = staffLegalPersistence;
    }

    @Override
    public void crearCuentaParaStaff(Long idCuenta) {
        //traer el staff que tiene este idCuenta
        StaffLegalDomain staffLegalDomain = adminPersistence.traerStaffPorId(idCuenta);
        if (staffLegalDomain != null && staffLegalDomain.getFkFigLegal().isActive()){
            //crear la cuenta con los datos de el staff legal obtenido
            CuentaDomain cuentaDomain = CuentaDomain.builder()
                    .ciUsuario(staffLegalDomain.getFkFigLegal().getCi())
                    .passUsuario(staffLegalDomain.getFkFigLegal().getCi())
                    .isActive(staffLegalDomain.getFkFigLegal().isActive())
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
        CuentaDomain cuentaDomainAdmin = staffLegalPersistence.buscarPorUserYPass(cuentaAdmin.getCiUsuario(), cuentaAdmin.getPassUsuario());
        CuentaDomain cuentaDomainChange = adminPersistence.traerCuentaPorID(idCuenta);
        if (cuentaDomainAdmin != null && cuentaDomainChange != null) {
            cuentaDomainChange.setPassUsuario(newPass);
            adminPersistence.crearCuentaParaStaff(cuentaDomainChange);
            //PROBAR ESTE METODO
        }
    }
}
