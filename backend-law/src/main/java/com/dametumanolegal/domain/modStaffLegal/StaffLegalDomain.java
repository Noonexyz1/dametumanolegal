package com.dametumanolegal.domain.modStaffLegal;

import com.dametumanolegal.domain.adapter.ModStaffLegal;
import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.port.Autenticable;
import com.dametumanolegal.request.InitSesionRequest;
import com.dametumanolegal.response.InitSesionResponse;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffLegalDomain implements Autenticable {
    private Long id;
    private String nombres;
    private String apellidos;
    private String ci;
    private boolean isActive;

    private ModStaffLegal persistencia;

    public StaffLegalDomain(ModStaffLegal persistenticia) {
        this.persistencia = persistenticia;
    }

    @Override   //esto es lo que voy a testear
    public InitSesionResponse iniciarSesion(InitSesionRequest initSesion) {
        CuentaDomain cuentaDomain = persistencia.buscarPorUserYPass(initSesion.getCiUser(), initSesion.getPassUser());
        if (cuentaDomain == null) {
            return InitSesionResponse.builder().estado("ESTA CUENTA NO ES ACEPTADA").build();
        } else {
            SesionDomain sesionDomain = SesionDomain.builder()
                    .estadoSesion(true)
                    .fechaSesion(LocalDateTime.now().toString())
                    .idStaffLegal(cuentaDomain.getIdStaffLegal())
                    .build();
            persistencia.crearSesion(sesionDomain);
            return InitSesionResponse.builder().cuentaDomain(cuentaDomain).build();
        }

    }

    @Override
    public InitSesionResponse cerrarSesion(InitSesionRequest closeSesion) {
        CuentaDomain cuentaDomain = persistencia.buscarPorUserYPass(closeSesion.getCiUser(), closeSesion.getPassUser());
        if (cuentaDomain == null) {
            return InitSesionResponse.builder().estado("ESTA CUENTA NO ES ACEPTADAaaa").build();
        } else {
            SesionDomain sesionDomain = SesionDomain.builder()
                    .estadoSesion(false)
                    .fechaSesion(LocalDateTime.now().toString())
                    .idStaffLegal(cuentaDomain.getIdStaffLegal())
                    .build();
            persistencia.crearSesion(sesionDomain);
            return InitSesionResponse.builder().estado("SESION TERMINADO").build();
        }
    }

    @Override
    public InitSesionResponse modificarPassword(InitSesionResponse initSesion) {
        persistencia.actualizar(initSesion.getCuentaDomain());
        return InitSesionResponse.builder().estado("CONTRASEÑA CAMBIADO").build();
    }
}
