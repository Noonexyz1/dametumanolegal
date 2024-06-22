package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.output.SecretariaPersistence;
import com.dametumanolegal.entities.Cita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SecretariaDomainTest {

    @Mock
    private SecretariaPersistence secrePersistence;
    @InjectMocks
    private SecretariaDomain secretariaDomain;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void registrarCuaderno() {
        CuadernoDomain cuadernoDomain = new CuadernoDomain(2L, "cuaderno del juzgado", "en progreso", "77777777", "8888888888", "5", "Subsanar una cosa", "Abgado, cliente, procurador", "Penal", "Caso Jabon en la olla");
        secretariaDomain.registrarCuaderno(cuadernoDomain);

        ArgumentCaptor<CuadernoDomain> captor = ArgumentCaptor.forClass(CuadernoDomain.class);
        verify(secrePersistence, times(1)).registrarCuaderno(captor.capture());

        CuadernoDomain cuadernoCaptor = captor.getValue();
        assertEquals(cuadernoDomain, cuadernoCaptor);
    }

    @Test
    void registrarMemorial() {
        HonorarioDomain honorario = new HonorarioDomain(1L, "Caso Judicial", "Caso de Judicial de un atraco", 200D, "Dolares");

        FiguraLegalDomain figuraLegal = new FiguraLegalDomain(3L, "Jose", "López", "7654321", "Avenida Comerdcial 456", "555-5678", "lopez@example.com", "Cliente", "1985-05-05", "Masculino", "2022-01-02", true);
        StaffLegalDomain staff = new StaffLegalDomain(3L, figuraLegal, null);
        ClienteDomain cliente = new ClienteDomain(1L, staff, null);

        FiguraLegalDomain figuraLegal2 = new FiguraLegalDomain(1L, "Juan", "Pérez", "1234567", "Calle Principaal 123", "555-1234", "perez@example.com", "Abogado", "1980-01-01", "Masculino", "2022-01-01", true);
        StaffLegalDomain staff2 = new StaffLegalDomain(1L, figuraLegal2, null);
        AbogadoDomain abogado = new AbogadoDomain(2L, false, staff2, null, null);

        FiguraLegalDomain figuraLegal3 = new FiguraLegalDomain(8L, "Juan", "Pérez", "1234567", "Calle Principal 123", "555-1234", "perfez@example.com", "Procurador", "1980-01-01", "Masculino", "2022-01-01", true);
        StaffLegalDomain staff3 = new StaffLegalDomain(8L, figuraLegal3, null);
        ProcuradorDomain procurador = new ProcuradorDomain(1L, staff3, null);

        CasoDomain casoDomain = new CasoDomain(1L, "Caso Quien se comio todo el dulce de leche", "En Progreso", "44444444", "22222222", "ninguna", "Judicial", "abogado, procurador, cliente", "Dulce de leche vacia", honorario, cliente, abogado, procurador);

        when(secrePersistence.findCasoPorId(anyLong())).thenReturn(casoDomain);


        MemorialDomain memorialDomain = new MemorialDomain(1L, "Tiene muchos archivos", "Memorial para el Caso nevera parlante", "77777777777", null);
        secretariaDomain.registrarMemorial(memorialDomain, 1L);

        ArgumentCaptor<MemorialDomain> captor = ArgumentCaptor.forClass(MemorialDomain.class);
        verify(secrePersistence, times(1)).registrarMemorial(captor.capture());

        MemorialDomain memoCaptor = captor.getValue();
        assertEquals(memoCaptor.getFkCaso(), casoDomain);
    }

    @Test
    void registrarCita() {
        FiguraLegalDomain figuraLegal = new FiguraLegalDomain(3L, "Jose", "López", "7654321", "Avenida Comerdcial 456", "555-5678", "lopez@example.com", "Cliente", "1985-05-05", "Masculino", "2022-01-02", true);
        StaffLegalDomain staff = new StaffLegalDomain(3L, figuraLegal, null);
        ClienteDomain cliente = new ClienteDomain(1L, staff, null);
        when(secrePersistence.findClientePorId(anyLong())).thenReturn(cliente);

        FiguraLegalDomain figuraLegal2 = new FiguraLegalDomain(1L, "Ana", "López", "7654321", "Avenida Norte 456", "555-5678", "lopez@example.com", "Secretaria", "1985-05-05", "Femenino", "2022-01-02", true);
        StaffLegalDomain staff2 = new StaffLegalDomain(7L, figuraLegal2, null);
        SecretariaDomain secretaria = new SecretariaDomain(1L, staff2, null);
        when(secrePersistence.findSecrePorId(anyLong())).thenReturn(secretaria);

        CitaDomain citaDomain = new CitaDomain(60L, "2024-06-17T10:00:00", 60, "Reunión para discutir la estrategia de defensa 'Ab...", "Despacho 404, Edificio Ilusión Jurídica", "En espera de que los planetas se alineen", "¡Importante! Llevar sombrero de mago para entrar.", "2024-06-17T09:00:00", "Abogado Mágico", null, null);

        secretariaDomain.registrarCita(citaDomain, 1L, 1L);

        ArgumentCaptor<CitaDomain> captor = ArgumentCaptor.forClass(CitaDomain.class);
        verify(secrePersistence, times(1)).registrarCita(captor.capture());

        CitaDomain cita = captor.getValue();
        assertEquals(1L, cita.getFkCliente().getId());
        assertEquals(1L, cita.getFkSecre().getId());
    }

    @Test
    void verCuadernos() {
        List<CuadernoDomain> cuadernos = new ArrayList<>();
        CuadernoDomain cuaderno1 = new CuadernoDomain(1L, "001", "Cuaderno del Juzgado 1", "Cuaderno utilizado para registrar todas las actividades del caso.", "2024-01-01", "2024-06-17", "Abierto", "Abogado", "Ninguna observación.", "Judicial");
        CuadernoDomain cuaderno2 = new CuadernoDomain(2L, "002", "Cuaderno del Juzgado 2", "Cuaderno para el seguimiento de pruebas y evidencias.", "2024-02-01", "2024-06-17", "En Progreso", "Procurador", "Requiere revisión semanal.", "Evidencia");
        cuadernos.add(cuaderno1);
        cuadernos.add(cuaderno2);

        when(secrePersistence.getListCuaderno()).thenReturn(cuadernos);

        List<CuadernoDomain> listCuadernos = secretariaDomain.verCuadernos();

        assertEquals(cuadernos, listCuadernos);
    }

    @Test
    void verMemoriales() {
        List<MemorialDomain> memoriales = new ArrayList<>();
        MemorialDomain memorial1 = new MemorialDomain(1L, "Memorial para Caso A", "Contenido del memorial para el caso A.", "2024-06-17T10:00:00", null);
        MemorialDomain memorial2 = new MemorialDomain(2L, "Memorial para Caso B", "Contenido del memorial para el caso B.", "2024-06-18T11:00:00", null);
        memoriales.add(memorial1);
        memoriales.add(memorial2);

        when(secrePersistence.getListMemorial()).thenReturn(memoriales);

        List<MemorialDomain> listMemoriales = secretariaDomain.verMemoriales();

        assertEquals(memoriales, listMemoriales);
    }

    @Test
    void verCasos() {
        List<CasoDomain> casos = new ArrayList<>();
        CasoDomain caso1 = new CasoDomain(1L, "Caso 'Quien se comio todo el dulce de leche'", "Investigación sobre el misterioso robo de dulce de leche.", "2024-01-01", "2024-06-17", "En progreso", "Judicial", "abogado, procurador, cliente", "Ninguna", null, null, null, null);
        CasoDomain caso2 = new CasoDomain(2L, "Caso 'Robo en la heladería'", "Investigación sobre el robo de helado en una heladería local.", "2024-02-01", "2024-06-18", "En progreso", "Judicial", "abogado, procurador, cliente", "Ninguna", null, null, null, null);
        casos.add(caso1);
        casos.add(caso2);

        when(secrePersistence.getListCaso()).thenReturn(casos);

        List<CasoDomain> listCasos = secretariaDomain.verCasos();

        assertEquals(casos, listCasos);
    }
}