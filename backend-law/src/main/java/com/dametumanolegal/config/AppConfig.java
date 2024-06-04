package com.dametumanolegal.config;

import com.dametumanolegal.domain.adapter.PersistenciaCuentaAdapter;
import com.dametumanolegal.domain.modStaffLegal.StaffLegal;
import com.dametumanolegal.domain.port.Autenticable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PersistenciaCuentaAdapter persistenciaCuentaAdapter() {
        return new PersistenciaCuentaAdapter();
    }

    @Bean
    public Autenticable staffLegal(PersistenciaCuentaAdapter persistenciaCuentaAdapter) {
        return new StaffLegal(persistenciaCuentaAdapter);
    }
}
