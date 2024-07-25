package com.dametumanolegal.application.impl;

import com.dametumanolegal.application.port.output.StaffLegalPersistence;
import com.dametumanolegal.domain.model.CuentaDomain;
import com.dametumanolegal.domain.model.SesionDomain;
import com.dametumanolegal.domain.port.input.Autenticable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StaffLegalDomainImpl implements Autenticable {

    private StaffLegalPersistence staffLegalPersistence;

    public StaffLegalDomainImpl(StaffLegalPersistence persistenticia) {
        this.staffLegalPersistence = persistenticia;
    }


    @Override   //esto es lo que voy a testear
    public SesionDomain iniciarSesion(CuentaDomain cuentaDomain) {
        /*TODO: verificar que el usuario haya cerrado sesion*/
        CuentaDomain cuenta = staffLegalPersistence.buscarPorUserYPass(cuentaDomain.getCiUsuario(), cuentaDomain.getPassUsuario());
        return  (cuenta != null)? createSesionDomainAndSave(cuenta): null;
        //Para no tener que estar propagando nulls, seria mejor que, en lugar de eso, lanzemos Excepciones personalizadas
    }

    private SesionDomain createSesionDomainAndSave(CuentaDomain cuenta){
        SesionDomain sesionDomain = SesionDomain.builder()
                .fechaSesion(LocalDateTime.now().toString())
                .estadoSesion(true)
                .fkStaffLegal(cuenta.getFkStaffLegal())
                .build();
        return staffLegalPersistence.crearSesion(sesionDomain);
    }

    @Override
    public void cerrarSesion(SesionDomain closeSesion) {
        /*TODO: verificar que el usuario haya iniciado sesion*/

        //closeSesion.setIdSesion(null);
        // Hay que jugar con el ID, Si quiero actualizar algo, JPA lo hace cuando le envias el ID,
        //si le mandas un ID null, entonces crea otro
        closeSesion.setIdSesion(null);
        closeSesion.setFechaSesion(LocalDateTime.now().toString());
        closeSesion.setEstadoSesion(false);
        staffLegalPersistence.crearSesion(closeSesion);
    }

    @Override
    public void modificarPassword(SesionDomain sesionDomain, CuentaDomain cuentaDomain, String newPass) {
        /*TODO: verificar antes de modificar password, que el usuario haya iniciado sesion*/
        CuentaDomain cuenta = staffLegalPersistence.buscarPorUserYPass(cuentaDomain.getCiUsuario(), cuentaDomain.getPassUsuario());
        if (isUserAuthenticated(cuenta, sesionDomain)) {
            cuenta.setPassUsuario(newPass);
            staffLegalPersistence.actualizar(cuenta);
        }
    }

    private boolean isUserAuthenticated(CuentaDomain cuenta, SesionDomain sesionDomain){
        return cuenta != null; /*&& (sesionDomain.getFkStaffLegal().equals(cuenta.getFkStaffLegal()));*/
    }
}