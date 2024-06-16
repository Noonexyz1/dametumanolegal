package com.dametumanolegal.config;

import com.dametumanolegal.domain.adapter.output.AdminPersistenceAdapter;
import com.dametumanolegal.domain.port.output.AdminPersistence;
import com.dametumanolegal.domain.port.output.StaffLegalPersistence;
import com.dametumanolegal.domain.AbogadoDomain;
import com.dametumanolegal.domain.StaffLegalDomain;
import com.dametumanolegal.domain.port.input.Autenticable;
import com.dametumanolegal.domain.port.input.Cuentable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /*@Bean no necesito este bean para registrarlo al scope porque la implementacion StaffLegalAdapter
    ya esta anotado con @component y por ende resitrado al Scope de Spring
    public ModStaffLegal persistenciaCuentaAdapter() {
        return new StaffLegalAdapter();
    }comentamos esto porque al haber dos iguales, Spring no sabia que Injectar en el metodo de abajo */

    @Bean //registrando este componente manualmente al Scope de Spring para quien sea que quiera la implementacion
    public Autenticable staffLegalDomain(/*@Qualifier("staffLegalAdapter")*/ StaffLegalPersistence staffLegalPersistence) {
        return new StaffLegalDomain(staffLegalPersistence);
    }






    @Bean
    public AdminPersistence persistenciaModAdmin(){
       return new AdminPersistenceAdapter();
    }

    @Bean(name = "abogadoCuentable")
    public Cuentable abogadoAdministradorCuentable(@Qualifier("persistenciaModAdmin") AdminPersistence adminPersistence) {
        return new AbogadoDomain(adminPersistence);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

