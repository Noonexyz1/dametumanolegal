package com.dametumanolegal.domain.adapter.output;

import com.dametumanolegal.domain.modAdmin.AsignacionDomain;
import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.modAdmin.RolDomain;
import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import com.dametumanolegal.domain.port.output.ModAdmin;
import com.dametumanolegal.entities.Asignacion;
import com.dametumanolegal.entities.Cuenta;
import com.dametumanolegal.entities.Rol;
import com.dametumanolegal.repository.AsignacionRepository;
import com.dametumanolegal.repository.CuentaRepository;
import com.dametumanolegal.repository.RolRepository;
import com.dametumanolegal.repository.StaffLegalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//ESTA CLASE se encarga de transformar ENTIDADES DE DOMINIO a entidades de BD
//Y este debe devolverlo en entidades de BD a ENTIDADES DE DOMINIO

@Component  //ADAPTADOR de SALIDA   //PUERTO de SALIDA de mi DOMAIN
public class AdminAdapter implements ModAdmin {

    @Autowired //PUERTO DE ENTRADA a mi SERVICIO para PERSISTENCIA
    private CuentaRepository cuentaRepository;
    @Autowired
    private AsignacionRepository asignacionRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private StaffLegalRepository staffLegalRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void crearCuentaParaStaff(CuentaDomain cuentaDomain) {
        Cuenta cuenta = modelMapper.map(cuentaDomain, Cuenta.class);
        cuentaRepository.save(cuenta);
    }

    @Override
    public CuentaDomain traerCuentaPorID(Long id) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(id);
        if (cuenta.isPresent()) {
            CuentaDomain cuentaDomain = modelMapper.map(cuenta.get(), CuentaDomain.class);
            return cuentaDomain;
        }
        return null;
    }



    @Override
    public void crearRol(RolDomain rolNuevo) {
        rolRepository.save(modelMapper.map(rolNuevo, Rol.class));
    }

    @Override
    public RolDomain traerRolPorId(Long id) {
        return modelMapper.map(rolRepository.findById(id), RolDomain.class);
    }

    @Override
    public void modificarRol(RolDomain rolModificado) {
        rolRepository.save(modelMapper.map(rolModificado, Rol.class));
    }

    @Override
    public List<RolDomain> listarRoles() {
        return rolRepository.findAll().stream().map(x -> modelMapper.map(x, RolDomain.class)).toList();
    }

    @Override
    public void desactivarRol(RolDomain rolDesactivado) {
        rolRepository.save(modelMapper.map(rolDesactivado, Rol.class));
    }

    @Override
    public void asiginarElRol(AsignacionDomain asignacion) {
        asignacionRepository.save(modelMapper.map(asignacion, Asignacion.class));
    }

    @Override
    public StaffLegalDomain traerStaffPorId(Long id) {
        return modelMapper.map(staffLegalRepository.findById(id), StaffLegalDomain.class);
    }
}
