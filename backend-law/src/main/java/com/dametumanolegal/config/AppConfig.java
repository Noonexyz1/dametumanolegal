package com.dametumanolegal.config;

import com.dametumanolegal.domain.*;
import com.dametumanolegal.domain.adapter.output.AdminPersistenceAdapter;
import com.dametumanolegal.domain.port.input.*;
import com.dametumanolegal.domain.port.output.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    //Las ambiguiedades de los Beans, se encuentran aqui, porque hay muchos beans de mismo tipo

    /*@Bean no necesito este bean para registrarlo al scope porque la implementacion StaffLegalAdapter
    ya esta anotado con @component y por ende resitrado al Scope de Spring
    public ModStaffLegal persistenciaCuentaAdapter() {
        return new StaffLegalAdapter();
    }comentamos esto porque al haber dos iguales, Spring no sabia que Injectar en el metodo de abajo */

    @Bean //registrando este componente manualmente al Scope de Spring para quien sea que quiera la implementacion
    public Autenticable staffLegalModulo(@Qualifier("staffLegalPersistenceAdapter") StaffLegalPersistence staffLegalPersistence) {
        // Al hacer esto, todas las clases que hereden de esta clase también serán consideradas Autenticables por Spring.
        // Spring reconocerá múltiples implementaciones de Autenticable debido a la herencia, por lo que se utilizará
        // el calificador (@Qualifier) para especificar cuál implementación se debe inyectar cuando sea necesario.
        //Entonces usar Qualifier("nombre del metodo del Bean")
        return new StaffLegalDomain(staffLegalPersistence);
    }

    @Bean/*(name = "abogadoCuentable")*/
    public Cuentable abogadoAdminModulo(@Qualifier("adminPersistenceAdapter") AdminPersistence adminPersistence/*, @Qualifier("staffLegalPersistenceAdapter") StaffLegalPersistence staffLegalPersistence*/) {
        // Estas clases también implementan Autenticable debido a la herencia (AbogadoDomain hereda de StaffLegalDomain),
        // por lo que se registra esta implementación en el contexto de Spring.
        return new AbogadoDomain(adminPersistence/*, staffLegalPersistence*/);
    }

    @Bean
    public Seguible clienteModulo(@Qualifier("clientePersistenceAdapter") ClientePersitence clientePersitence){
        return new ClienteDomain(clientePersitence);
    }

    @Bean
    public Gestionable secretariaModulo(@Qualifier("secretariaPersistenceAdapter") SecretariaPersistence secrePersistence){
        return new SecretariaDomain(secrePersistence);
    }

    @Bean
    public Procurable procurableModulo(@Qualifier("procuradorPersistenceAdapter") ProcuradorPersistence procuradorPersistence){
        return new ProcuradorDomain(procuradorPersistence);
    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

