package com.dametumanolegal.domain;

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

    public StaffLegalDomain(Long id, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive){
        super(id, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive);
    }


    @Override   //esto es lo que voy a testear
    public SesionDomain iniciarSesion(CuentaDomain cuentaDomain) {
        CuentaDomain cuenta = staffLegalPersistence.buscarPorUserYPass(cuentaDomain.getCiUsuario(), cuentaDomain.getPassUsuario());
        if (cuenta == null) {
            return null;
        } else {
            SesionDomain sesionDomain = SesionDomain.builder()
                    .estadoSesion(true)
                    .fechaSesion(LocalDateTime.now().toString())
                    .fkStaffLegal(cuenta.getFkStaffLegal())
                    .build();

            sesionDomain = staffLegalPersistence.crearSesion(sesionDomain);
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
        staffLegalPersistence.crearSesion(closeSesion);
    }

    @Override
    public void modificarPassword(SesionDomain sesionDomain, CuentaDomain cuentaDomain, String newPass) {
        CuentaDomain cuenta = staffLegalPersistence.buscarPorUserYPass(cuentaDomain.getCiUsuario(), cuentaDomain.getPassUsuario());
        if (!(cuenta == null) && (sesionDomain.getFkStaffLegal().equals(cuenta.getFkStaffLegal()))) {
            cuenta.setPassUsuario(newPass);
            staffLegalPersistence.actualizar(cuenta);
        }
    }
}