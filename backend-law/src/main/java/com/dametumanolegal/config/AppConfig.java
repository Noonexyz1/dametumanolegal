package com.dametumanolegal.config;

import com.dametumanolegal.domain.adapter.PersistenciaModStaffLegal;
import com.dametumanolegal.domain.adapter.PersistenciaStaffLegal;
import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import com.dametumanolegal.domain.port.Autenticable;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PersistenciaModStaffLegal persistenciaCuentaAdapter() {
        return new PersistenciaStaffLegal();
    }

    @Bean
    public Autenticable staffLegal(PersistenciaModStaffLegal persistenciaCuentaAdapter) {
        return new StaffLegalDomain(persistenciaCuentaAdapter);
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
