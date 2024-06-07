package com.dametumanolegal.config;

import com.dametumanolegal.domain.adapter.ModAdminPersist;
import com.dametumanolegal.domain.adapter.ModAdminPersistAdapter;
import com.dametumanolegal.domain.adapter.ModStaffLegal;
import com.dametumanolegal.domain.adapter.ModStaffLegalAdapter;
import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import com.dametumanolegal.domain.port.Autenticable;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModStaffLegal persistenciaCuentaAdapter() {
        return new ModStaffLegalAdapter();
    }
    @Bean
    public Autenticable staffLegal(ModStaffLegal persistenciaCuentaAdapter) {
        return new StaffLegalDomain(persistenciaCuentaAdapter);
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ModAdminPersist persistenciaModAdmin(){
        return new ModAdminPersistAdapter();
    }

}
