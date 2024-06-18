package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.output.StaffLegalPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//Clase adaptador
public class StaffLegalDomainTest {

    // Mock del persistence layer
    @Mock
    private StaffLegalPersistence staffLegalPersistence;

    // Clase bajo prueba, se injectan los mocks
    @InjectMocks    //esto es lo que se adapta, necesita el constructor de esta clase y no Autenticable para funcionar
    private StaffLegalDomain staffLegalDomain;

    @BeforeEach
    public void setUp() {
        // Inicializar los mocks y la clase bajo prueba
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIniciarSesion() {
        // GIVEN datos iniciales
        FiguraLegalDomain figuraLegal = FiguraLegalDomain.builder().id(1L).nombres("Juan").apellidos("Pérez").ci("1234567").direccion("Calle Principal 123").email("perez@example.com").fechaNacimiento("1980-01-01").fechaRegistro("2022-01-01").genero("Masculino").telefono("555-1234").rol("Abogado").build();
        StaffLegalDomain staff = StaffLegalDomain.builder().id(1L).fkFigLegal(figuraLegal).build();
        CuentaDomain cuentaDomain = CuentaDomain.builder().isActive(true).fkStaffLegal(staff).id(1L).ciUsuario("1234567").passUsuario("123").build();
        SesionDomain sesionMock = SesionDomain.builder().idSesion(1L).fechaSesion(LocalDateTime.now().toString()).estadoSesion(true).fkStaffLegal(staff).build();
        CuentaDomain cuentaToPrube = CuentaDomain.builder().ciUsuario("1234567").passUsuario("123").build();

        // Mockear el comportamiento del método buscarPorUserYPass en persistencia
        when(staffLegalPersistence.buscarPorUserYPass(anyString(), anyString())).thenReturn(cuentaDomain);
        // Mockear el comportamiento del método crearSesion en persistencia
        when(staffLegalPersistence.crearSesion(any(SesionDomain.class))).thenReturn(sesionMock);

        // WHEN Llamar al método bajo prueba
        SesionDomain result = staffLegalDomain.iniciarSesion(cuentaToPrube);

        // THEN Verificar que se creó correctamente la sesión
        assertNotNull(result);
        assertTrue(result.isEstadoSesion());
        assertNotNull(result.getFechaSesion());

        // Verificar que se llamó al método crearSesion en persistencia
        verify(staffLegalPersistence).crearSesion(any(SesionDomain.class));
    }

    @Test
    public void testCerrarSesion() {
        // Datos de prueba
        // GIVEN datos iniciales
        FiguraLegalDomain figuraLegal = FiguraLegalDomain.builder().id(1L).nombres("Juan").apellidos("Pérez").ci("1234567").direccion("Calle Principal 123").email("perez@example.com").fechaNacimiento("1980-01-01").fechaRegistro("2022-01-01").genero("Masculino").telefono("555-1234").rol("Abogado").build();
        StaffLegalDomain staff = StaffLegalDomain.builder().id(1L).fkFigLegal(figuraLegal).build();
        SesionDomain sesionMock = SesionDomain.builder().idSesion(1L).fechaSesion(LocalDateTime.now().toString()).estadoSesion(true).fkStaffLegal(staff).build();

        // Llamar al método bajo prueba
        staffLegalDomain.cerrarSesion(sesionMock);

        // Verificar que se modificó correctamente la sesión
        assertNull(sesionMock.getIdSesion());
        assertFalse(sesionMock.isEstadoSesion());
        assertNotNull(sesionMock.getFechaSesion());

        // Verificar que se llamó al método crearSesion en persistencia
        verify(staffLegalPersistence).crearSesion(any(SesionDomain.class));
    }

    @Test
    public void testModificarPassword() {
        // GIVEN datos iniciales
        FiguraLegalDomain figuraLegal = FiguraLegalDomain.builder().id(1L).nombres("Juan").apellidos("Pérez").ci("1234567").direccion("Calle Principal 123").email("perez@example.com").fechaNacimiento("1980-01-01").fechaRegistro("2022-01-01").genero("Masculino").telefono("555-1234").rol("Abogado").build();
        StaffLegalDomain staff = StaffLegalDomain.builder().id(1L).fkFigLegal(figuraLegal).build();
        CuentaDomain cuentaDomain = CuentaDomain.builder().isActive(true).fkStaffLegal(staff).id(1L).ciUsuario("1234567").passUsuario("123").build();

        SesionDomain sesionMock = SesionDomain.builder().idSesion(1L).fechaSesion(LocalDateTime.now().toString()).estadoSesion(true).fkStaffLegal(staff).build();
        CuentaDomain cuentaToPrube = CuentaDomain.builder().ciUsuario("1234567").passUsuario("123").build();

        // Mockear el comportamiento del método buscarPorUserYPass en persistencia
        when(staffLegalPersistence.buscarPorUserYPass(anyString(), anyString())).thenReturn(cuentaDomain);

        // Llamar al método bajo prueba
        staffLegalDomain.modificarPassword(sesionMock, cuentaToPrube, "nuevaContraseña");

        // Verificar que se actualizó correctamente la cuenta
        assertEquals("nuevaContraseña", cuentaDomain.getPassUsuario());

        // Verificar que se llamó al método actualizar en persistencia
        verify(staffLegalPersistence).actualizar(any(CuentaDomain.class));
    }
}