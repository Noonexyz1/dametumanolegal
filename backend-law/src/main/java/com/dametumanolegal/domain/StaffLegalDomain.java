package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.output.StaffLegalPersistence;
import com.dametumanolegal.domain.port.input.Autenticable;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder    //esto no esta registrado en el scope de Spring, lo tengo que hacer manual, por AppConfig
public class StaffLegalDomain implements Autenticable {
    private Long id;

    private FiguraLegalDomain fkFigLegal;

    //esto es para recibir la injeccion
    private StaffLegalPersistence persistencia;
    //aqui esta el unico Constructor
    public StaffLegalDomain(StaffLegalPersistence persistenticia) {
        this.persistencia = persistenticia;
    }

    @Override   //esto es lo que voy a testear
    public SesionDomain iniciarSesion(CuentaDomain cuentaDomain) {
        CuentaDomain cuenta = persistencia.buscarPorUserYPass(cuentaDomain.getCiUsuario(), cuentaDomain.getPassUsuario());
        if (cuenta == null) {
            return null;
        } else {
            SesionDomain sesionDomain = SesionDomain.builder()
                    .estadoSesion(true)
                    .fechaSesion(LocalDateTime.now().toString())
                    .fkStaffLegal(cuenta.getFkStaffLegal())
                    .build();

            sesionDomain = persistencia.crearSesion(sesionDomain);
            return sesionDomain;
        }
    }

    @Override
    public void cerrarSesion(SesionDomain closeSesion) {
        //closeSesion.setIdSesion(null);
        // Hay que jugar con el ID, Si quiero actualizar algo, JPA lo hace cuando le envias el ID,
        //si le mandas un ID null, entonces crea otro
        closeSesion.setIdSesion(null);
        closeSesion.setEstadoSesion(false);
        closeSesion.setFechaSesion(LocalDateTime.now().toString());
        persistencia.crearSesion(closeSesion);
    }

    @Override
    public void modificarPassword(SesionDomain sesionDomain, CuentaDomain cuentaDomain, String newPass) {
        CuentaDomain cuenta = persistencia.buscarPorUserYPass(cuentaDomain.getCiUsuario(), cuentaDomain.getPassUsuario());
        if (!(cuenta == null) && (sesionDomain.getFkStaffLegal().equals(cuenta.getFkStaffLegal()))) {
            cuenta.setPassUsuario(newPass);
            persistencia.actualizar(cuenta);
        }
    }
}