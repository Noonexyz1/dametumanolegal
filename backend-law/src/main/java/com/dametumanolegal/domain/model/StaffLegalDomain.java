package com.dametumanolegal.domain.model;

import com.dametumanolegal.domain.port.output.StaffLegalPersistence;
import com.dametumanolegal.domain.port.input.Autenticable;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
//esto no esta registrado en el scope de Spring, lo tengo que hacer manual, por AppConfig
public class StaffLegalDomain extends FiguraLegalDomain implements Autenticable {
    private Long id;

    //esto es para recibir la injeccion
    // Nota: NO VOY A PONER MI @Qualifier AQUI!!, es mi dominio!!, mejor lo pongo en mi Bean de AppConfig y asunto resuelto!!
    private StaffLegalPersistence staffLegalPersistence;
    //aqui esta el unico Constructor
    public StaffLegalDomain(StaffLegalPersistence persistenticia) {
        this.staffLegalPersistence = persistenticia;
    }

    public StaffLegalDomain(Long id, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idStaffLegal){
        super(id, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive);
        this.id = idStaffLegal;
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