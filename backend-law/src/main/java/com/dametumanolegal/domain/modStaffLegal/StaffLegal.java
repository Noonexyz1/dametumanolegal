package com.dametumanolegal.domain.modStaffLegal;

import com.dametumanolegal.domain.adapter.PersistenciaCuentaAdapter;
import com.dametumanolegal.domain.modAdmin.Abogado;
import com.dametumanolegal.domain.modAdmin.Asignacion;
import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.port.Autenticable;
import com.dametumanolegal.request.InitSesionRequest;
import com.dametumanolegal.response.InitSesionResponse;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffLegal implements Autenticable {
    private Long id;
    private String nombres;
    private String apellidos;
    private String ci;
    private boolean isActive;

    private List<Abogado> listaAbogados;
    private List<CuentaDomain> listaCuentas;
    private List<Sesion> listaSesiones;
    private List<Asignacion> listaAsginaciones;

    PersistenciaCuentaAdapter persistenticia;

    public StaffLegal(PersistenciaCuentaAdapter persistenticia) {
        this.persistenticia = persistenticia;
    }

    @Override   //esto es lo que voy a testear
    public InitSesionResponse iniciarSesion(InitSesionRequest initSesion) {
        CuentaDomain cuenta = new CuentaDomain();
        cuenta.setCiUsuario(initSesion.getCiUser());
        cuenta.setPassUsuario(initSesion.getPassUser());

        cuenta = persistenticia.crear(cuenta);

        return InitSesionResponse.builder()
                .ciUser(cuenta.getCiUsuario())
                .passUser(cuenta.getPassUsuario()).build();
    }

    @Override
    public InitSesionResponse cerrarSesion(InitSesionRequest initSesion) {
        return null;
    }
}
