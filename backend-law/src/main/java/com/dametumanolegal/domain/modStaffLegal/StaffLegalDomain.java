package com.dametumanolegal.domain.modStaffLegal;

import com.dametumanolegal.domain.port.output.ModStaffLegal;
import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.port.input.Autenticable;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffLegalDomain implements Autenticable {
    private Long idStaffLegal;
    private String nombres;
    private String apellidos;
    private String ci;
    private boolean isActive;

    private ModStaffLegal persistencia;

    public StaffLegalDomain(ModStaffLegal persistenticia) {
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
                    .fk(cuenta.getFk())
                    .build();
            persistencia.crearSesion(sesionDomain);
            return sesionDomain;
        }
    }

    @Override
    public void cerrarSesion(SesionDomain closeSesion) {
        //closeSesion.setIdSesion(null);
        closeSesion.setEstadoSesion(false);
        closeSesion.setFechaSesion(LocalDateTime.now().toString());
        persistencia.crearSesion(closeSesion);
    }

    @Override
    public void modificarPassword(CuentaDomain cuentaDomain) {
        CuentaDomain cuenta = persistencia.buscarPorUserYPass(cuentaDomain.getCiUsuario(), cuentaDomain.getPassUsuario());
        if (!(cuenta == null)) {
            cuenta.setPassUsuario(cuentaDomain.getPassUsuario());
            persistencia.actualizar(cuenta);
        }
    }
}