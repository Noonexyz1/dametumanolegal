package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.output.AdminPersistence;
import com.dametumanolegal.domain.port.input.Cuentable;
import com.dametumanolegal.domain.port.output.StaffLegalPersistence;
import lombok.*;

//Esta clase se encarga de recibir entradas de TIPOS o ATRIBUTOS o ENTIDADES DE DOMINIO
//y hacer la operacion de devolver de ENTIDADES DE DOMINIO o TIPOS como respuesta
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbogadoDomain extends StaffLegalDomain  implements Cuentable {
    private Long idAbogado;
    private boolean isAdmin;

    private AdminPersistence adminPersistence;
    //private StaffLegalPersistence staffLegalPersistence;
    //porque estoy volviendo a escribir esta dependencia si la dependencia ya viene del padre al hacer herencia
    //Osea, no es ambiguo??????

    /*public AbogadoDomain(AdminPersistence adminPersistence, StaffLegalPersistence staffLegalPersistence){
        this.adminPersistence = adminPersistence;
        this.staffLegalPersistence = staffLegalPersistence;
    }*/
    public AbogadoDomain(AdminPersistence adminPersistence){
        this.adminPersistence = adminPersistence;
    }


    public AbogadoDomain(Long id, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idAbogado, boolean isAdmin){
        super(id, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive);
        this.idAbogado = idAbogado;
        this.isAdmin = isAdmin;
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
        CuentaDomain cuentaDomainAdmin = getStaffLegalPersistence().buscarPorUserYPass(cuentaAdmin.getCiUsuario(), cuentaAdmin.getPassUsuario());
        CuentaDomain cuentaDomainChange = adminPersistence.traerCuentaPorID(idCuenta);
        if (cuentaDomainAdmin != null && cuentaDomainChange != null) {
            cuentaDomainChange.setPassUsuario(newPass);
            adminPersistence.crearCuentaParaStaff(cuentaDomainChange);
            //PROBAR ESTE METODO
        }
    }
}
