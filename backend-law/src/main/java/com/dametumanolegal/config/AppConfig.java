package com.dametumanolegal.config;

import com.dametumanolegal.domain.adapter.output.AdminAdapter;
import com.dametumanolegal.domain.port.output.ModAdmin;
import com.dametumanolegal.domain.port.output.ModStaffLegal;
import com.dametumanolegal.domain.adapter.output.StaffLegalAdapter;
import com.dametumanolegal.domain.modAdmin.AbogadoDomain;
import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import com.dametumanolegal.domain.port.input.Autenticable;
import com.dametumanolegal.domain.port.input.Cuentable;
import com.dametumanolegal.domain.port.input.Rolable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModStaffLegal persistenciaCuentaAdapter() {
        return new StaffLegalAdapter();
    }
    @Bean
    public Autenticable staffLegal(@Qualifier("staffLegalAdapter") ModStaffLegal modStaffLegal) {
        return new StaffLegalDomain(modStaffLegal);
    }


    @Bean
    public ModAdmin persistenciaModAdmin(){
       return new AdminAdapter();
    }
    @Bean(name = "abogadoCuentable")
    public Cuentable abogadoAdministradorCuentable(@Qualifier("persistenciaModAdmin") ModAdmin modAdmin) {
        return new AbogadoDomain(modAdmin);
    }

    @Bean(name = "abogadoRolable")
    public Rolable abogadoAdministradorRolable(@Qualifier("persistenciaModAdmin") ModAdmin modAdmin) {
        return new AbogadoDomain(modAdmin);
    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

