package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.output.ProcuradorPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ProcuradorDomainTest {

    @Mock
    private ProcuradorPersistence procuradorPersistence;
    @InjectMocks
    private ProcuradorDomain procuradorDomain;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void registrarNotificacion() {
        NotificacionDomain notiDomain = new NotificacionDomain(null, "Penal", "7777", "Esto es el contenido");
        procuradorDomain.registrarNotificacion(notiDomain);

        ArgumentCaptor<NotificacionDomain> captor = ArgumentCaptor.forClass(NotificacionDomain.class);
        verify(procuradorPersistence, times(1)).setNotificacion(captor.capture());

        NotificacionDomain notifi = captor.getValue();
        assertEquals(notiDomain, notifi);
    }

    @Test
    void registrarActuado() {
        CasoDomain casoDomain = new CasoDomain(1L, "Caso Quien se comio todo el dulce de leche", "En Progreso", "44444444", "22222222", "ninguna", "Judicial", "abogado, procurador, cliente", "Dulce de leche vacia", null, null, null, null);

        when(procuradorPersistence.getCasoPorId(anyLong())).thenReturn(casoDomain);


        ActuadoDomain actuadoDomain = new ActuadoDomain(null, "Penal", "Descripcion", "777", "Procurador", "Contenido", null);

        procuradorDomain.registrarActuado(actuadoDomain, 1L);

        ArgumentCaptor<ActuadoDomain> captor = ArgumentCaptor.forClass(ActuadoDomain.class);
        verify(procuradorPersistence, times(1)).setActuado(captor.capture());

        ActuadoDomain actuado = captor.getValue();
        assertEquals(casoDomain, actuado.getFkCaso());
    }


    @Test
    void verCasos() {
        List<CasoDomain> casos = new ArrayList<>();
        CasoDomain caso1 = new CasoDomain(1L, "Caso 'Quien se comio todo el dulce de leche'", "Investigación sobre el misterioso robo de dulce de leche.", "2024-01-01", "2024-06-17", "En progreso", "Judicial", "abogado, procurador, cliente", "Ninguna", null, null, null, null);
        CasoDomain caso2 = new CasoDomain(2L, "Caso 'Robo en la heladería'", "Investigación sobre el robo de helado en una heladería local.", "2024-02-01", "2024-06-18", "En progreso", "Judicial", "abogado, procurador, cliente", "Ninguna", null, null, null, null);
        casos.add(caso1);
        casos.add(caso2);

        when(procuradorPersistence.getCasos()).thenReturn(casos);

        List<CasoDomain> listCasos = procuradorDomain.verCasos();

        assertEquals(casos, listCasos);
    }

    @Test
    void verCuadernos() {
        List<CuadernoDomain> cuadernos = new ArrayList<>();
        CuadernoDomain cuaderno1 = new CuadernoDomain(1L, "001", "Cuaderno del Juzgado 1", "Cuaderno utilizado para registrar todas las actividades del caso.", "2024-01-01", "2024-06-17", "Abierto", "Abogado", "Ninguna observación.", "Judicial");
        CuadernoDomain cuaderno2 = new CuadernoDomain(2L, "002", "Cuaderno del Juzgado 2", "Cuaderno para el seguimiento de pruebas y evidencias.", "2024-02-01", "2024-06-17", "En Progreso", "Procurador", "Requiere revisión semanal.", "Evidencia");
        cuadernos.add(cuaderno1);
        cuadernos.add(cuaderno2);

        when(procuradorPersistence.getCuadernos()).thenReturn(cuadernos);

        List<CuadernoDomain> listCuadernos = procuradorDomain.verCuadernos();
        assertEquals(cuadernos, listCuadernos);
    }

    @Test
    void verFiscales() {
        List<FiscalDomain> fiscales = new ArrayList<>();
        fiscales.add(new FiscalDomain(1L, null, null));
        fiscales.add(new FiscalDomain(2L, null, null));

        when(procuradorPersistence.getFiscales()).thenReturn(fiscales);

        List<FiscalDomain> listFiscales = procuradorDomain.verFiscales();
        assertEquals(fiscales, listFiscales);
    }

    @Test
    void verCasosFiscalia() {
        List<CasoFiscaliaDomain> casosFiscalia = new ArrayList<>();
        casosFiscalia.add(new CasoFiscaliaDomain(1L, null));
        casosFiscalia.add(new CasoFiscaliaDomain(2L, null));

        when(procuradorPersistence.getCasosFiscalia()).thenReturn(casosFiscalia);

        List<CasoFiscaliaDomain> listCasFis = procuradorDomain.verCasosFiscalia();
        assertEquals(casosFiscalia, listCasFis);
    }
}