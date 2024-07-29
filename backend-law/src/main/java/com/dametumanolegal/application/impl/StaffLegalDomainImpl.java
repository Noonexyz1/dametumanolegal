package com.dametumanolegal.application.impl;

import com.dametumanolegal.application.datacarries.CuentaDataCarrier;
import com.dametumanolegal.application.datacarries.SesionDataCarrier;
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
        //TODO hacer mapeo
        CuentaDataCarrier cuentaDataCarrier = staffLegalPersistence.buscarPorUserYPass(cuentaDomain.getCiUsuario(), cuentaDomain.getPassUsuario());


        return  (cuentaDataCarrier != null)? createSesionDomainAndSave(cuentaDataCarrier): null;
        //Para no tener que estar propagando nulls, seria mejor que, en lugar de eso, lanzemos Excepciones personalizadas
    }

    private SesionDomain createSesionDomainAndSave(CuentaDataCarrier cuentaDataCarrier){

        //TODO hacer los mapeos
        SesionDataCarrier sesionDataCarrier = new SesionDataCarrier();

        SesionDomain sesionDomain = SesionDomain.builder()
                .fechaSesion(LocalDateTime.now().toString())
                .estadoSesion(true)
                //.fkStaffLegal(cuentaDataCarrier.getFkStaffLegal())
                .build();

        SesionDataCarrier sesionDomain1 = staffLegalPersistence.crearSesion(sesionDataCarrier);

        //TODO hacer los mapeos
        SesionDomain sesionDomain2 = SesionDomain.builder().build();
        return sesionDomain2;
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

        //TODO hacer el mapeo correspondiente
        SesionDataCarrier sesionDataCarrier = new SesionDataCarrier();

        staffLegalPersistence.crearSesion(sesionDataCarrier);
    }

    @Override
    public void modificarPassword(SesionDomain sesionDomain, CuentaDomain cuentaDomain, String newPass) {
        /*TODO: verificar antes de modificar password, que el usuario haya iniciado sesion*/
        CuentaDataCarrier cuentaDataCarrier = staffLegalPersistence.buscarPorUserYPass(cuentaDomain.getCiUsuario(), cuentaDomain.getPassUsuario());
        if (isUserAuthenticated(cuentaDataCarrier, sesionDomain)) {
            cuentaDataCarrier.setPassUsuario(newPass);
            staffLegalPersistence.actualizar(cuentaDataCarrier);
        }
    }

    private boolean isUserAuthenticated(CuentaDataCarrier cuentaDataCarrier, SesionDomain sesionDomain){
        return cuentaDataCarrier != null; /*&& (sesionDomain.getFkStaffLegal().equals(cuenta.getFkStaffLegal()));*/
    }
}