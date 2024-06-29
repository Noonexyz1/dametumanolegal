package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.output.ClientePersitence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


class ClienteDomainTest {

    @Mock
    private ClientePersitence clientePersitence;
    @InjectMocks    //Esto es un adapter
    private ClienteDomain clienteDomain;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void verTramite() {
        ClienteDomain cliente = new ClienteDomain(3L, "Jose", "López", "7654321", "Avenida Comercial 456", "555-5678", "lopez@example.com", "Cliente", "1985-05-05", "Masculino", "2022-01-02", true, 1L);
        AbogadoDomain abogado = new AbogadoDomain(1L, "Juan", "Pérez", "1234567", "Calle Principal 123", "555-1234", "perez@example.com", "Abogado", "1980-01-01", "Masculino", "2022-01-01", true,1L, true);
        HonorarioDomain honorario = new HonorarioDomain(1L, "Caso Judicial", "Caso de Judicial de un atraco", 200D, "Dolares");
        SubsanacionDomain subsanacion = new SubsanacionDomain(1L, 7, "77777", "99999", "Subsanacion de memorial 23-FD");

        TramiteDomain tramite = new TramiteDomain(1L, true, 12, 10, "Juzgado 3RO", cliente, abogado, honorario, subsanacion);

        when(clientePersitence.verProcTram(anyLong())).thenReturn(tramite);

        TramiteDomain tramiteDomain = clienteDomain.verTramite(1L);
        assertEquals(1L, tramiteDomain.getId());
        // Verifica que los objetos tramite y tramiteDomain sean iguales
        assertEquals(tramite, tramiteDomain);

    }

    @Test
    void verDocumentacionTram() {
        DocumentacionDomain documentacion = new DocumentacionDomain(1L, "Documentos para tramite", "Sin copias", true, "888888888888888", "99999999999999999", "Certificado nacimiento", "Sin Observaciones", "Abogado y cliente", "Tramite");
        when(clientePersitence.verDocumentacionTram(anyLong())).thenReturn(documentacion);

        DocumentacionDomain docDomain = clienteDomain.verDocumentacionTram(1L);
        assertEquals(1L, docDomain.getId());
        assertEquals(documentacion, docDomain);
    }

    @Test
    void verHonorario() {
        HonorarioDomain honorario = new HonorarioDomain(1L, "Tramite", "Dolares", 23D, "Tramite");
        when(clientePersitence.getHonorario(anyLong())).thenReturn(honorario);

        HonorarioDomain honoDom = clienteDomain.verHonorario(1L);
        assertEquals(1L, honoDom.getId());
        assertEquals(honorario, honoDom);
    }

    @Test
    void verNotificacion() {
        NotificacionDomain notiDom = new NotificacionDomain(1L, "Penal", "777777777", "Notificacion para el caso legal penal TAL");
        when(clientePersitence.getNotificacion(anyLong())).thenReturn(notiDom);

        NotificacionDomain notificacion = clienteDomain.verNotificacion(1L);
        assertEquals(1L, notificacion.getId());
        assertEquals(notiDom, notificacion);
    }
}