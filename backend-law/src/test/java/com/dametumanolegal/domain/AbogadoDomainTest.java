package com.dametumanolegal.domain;

import com.dametumanolegal.domain.model.AbogadoDomain;
import com.dametumanolegal.domain.model.CuentaDomain;
import com.dametumanolegal.domain.model.StaffLegalDomain;
import com.dametumanolegal.application.port.output.AdminPersistence;
import com.dametumanolegal.application.port.output.StaffLegalPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AbogadoDomainTest {

    @Mock
    private AdminPersistence adminPersistence;
    @Mock
    private StaffLegalPersistence staffLegalPersistence;

    @InjectMocks
    private AbogadoDomain abogadoAdminDomain;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void crearCuentaParaStaff() {
        // Crear el objeto StaffLegalDomain utilizando FiguraLegalDomain
        StaffLegalDomain staff = new StaffLegalDomain(1L, "Juan", "Pérez", "1234567", "Calle Principal 123", "555-1234", "perez@example.com", "Abogado", "1980-01-01", "Masculino", "2022-01-01", true, 1L);

        // Configurar el mock para que devuelva el objeto staff cuando se llame al método traerStaffPorId
        when(adminPersistence.traerStaffPorId(anyLong())).thenReturn(staff);

        // Llamar al método que se quiere testear
        abogadoAdminDomain.crearCuentaParaStaff(1L);

        // Capturar el argumento pasado al método crearCuentaParaStaff
        ArgumentCaptor<CuentaDomain> captor = ArgumentCaptor.forClass(CuentaDomain.class);
        verify(adminPersistence, times(1)).crearCuentaParaStaff(captor.capture());

        // Verificar los valores de CuentaDomain
        CuentaDomain cuentaDomain = captor.getValue();
        assertEquals("1234567", cuentaDomain.getCiUsuario());
        assertEquals("1234567", cuentaDomain.getPassUsuario());
        assertTrue(cuentaDomain.isActive());
        assertEquals(staff, cuentaDomain.getFkStaffLegal());
    }

    @Test
    void traerCuentaPorId() {
        StaffLegalDomain staff = new StaffLegalDomain(1L, "Juan", "Pérez", "1234567", "Calle Principal 123", "555-1234", "perez@example.com", "Abogado", "1980-01-01", "Masculino", "2022-01-01", true, 1L);
        CuentaDomain cuenta = new CuentaDomain( 1L, "1234567", "123",true, staff);
        when(adminPersistence.traerCuentaPorID(anyLong())).thenReturn(cuenta);

        CuentaDomain cuentaDomain = abogadoAdminDomain.traerCuentaPorId(1L);
        // Verificar que el password se haya seteado a null
        assertNotNull(cuentaDomain); // Verificar que no sea null
        assertEquals("1234567", cuentaDomain.getCiUsuario()); // Verificar que ciUsuario es correcto
        assertNull(cuentaDomain.getPassUsuario()); // Verificar que passUsuario se haya seteado a null
        assertTrue(cuentaDomain.isActive()); // Verificar que isActive es correcto
        assertEquals(staff, cuentaDomain.getFkStaffLegal()); // Verificar que fkStaffLegal es correcto


        //CUANDO NO EXISTE EL ID
        // Configurar el mock para que devuelva null cuando se llame al método traerCuentaPorID
        when(adminPersistence.traerCuentaPorID(anyLong())).thenReturn(null);
        // Llamar al método que se quiere testear
        CuentaDomain result = abogadoAdminDomain.traerCuentaPorId(100L);
        // Verificar que el resultado sea null
        assertNull(result);
    }

    @Test
    void desactivarCuentaDeStaff() {
        StaffLegalDomain staff = new StaffLegalDomain(1L, "Juan", "Pérez", "1234567", "Calle Principal 123", "555-1234", "perez@example.com", "Abogado", "1980-01-01", "Masculino", "2022-01-01", true, 1L);
        CuentaDomain cuenta = new CuentaDomain( 1L, "1234567", "123",true, staff);
        when(adminPersistence.traerCuentaPorID(anyLong())).thenReturn(cuenta);

        abogadoAdminDomain.desactivarCuentaDeStaff(1L);

        // Capturar el argumento pasado al método crearCuentaParaStaff
        ArgumentCaptor<CuentaDomain> captor = ArgumentCaptor.forClass(CuentaDomain.class);
        verify(adminPersistence, times(1)).crearCuentaParaStaff(captor.capture());

        // Verificar los valores de CuentaDomain
        CuentaDomain cuentaDomain = captor.getValue();
        assertEquals("1234567", cuentaDomain.getCiUsuario());
        assertEquals("123", cuentaDomain.getPassUsuario());
        assertEquals(staff, cuentaDomain.getFkStaffLegal());
        assertFalse(cuentaDomain.isActive());
    }

    @Test
    void modifiPassCuentaDeStaff() {
        StaffLegalDomain staff = new StaffLegalDomain(1L, "Juan", "Pérez", "1234567", "Calle Principal 123", "555-1234", "perez@example.com", "Abogado", "1980-01-01", "Masculino", "2022-01-01", true, 1L);
        CuentaDomain cuentaAdmin = new CuentaDomain( 1L, "1234567", "123",true, staff);
        when(staffLegalPersistence.buscarPorUserYPass(anyString(), anyString())).thenReturn(cuentaAdmin);

        StaffLegalDomain staff1 = new StaffLegalDomain(1L, "Juan", "Pérez", "1234567", "Calle Principal 123", "555-1234", "perez@example.com", "Abogado", "1980-01-01", "Masculino", "2022-01-01", true, 1L);
        CuentaDomain cuenta = new CuentaDomain( 1L, "1234567", "123",true, staff1);
        when(adminPersistence.traerCuentaPorID(anyLong())).thenReturn(cuenta);


        CuentaDomain cuentaAdminToProbe = new CuentaDomain( null, "1234567", "123",false, null);
        abogadoAdminDomain.modifiPassCuentaDeStaff(cuentaAdminToProbe, 1L, "DIEGO");


        // Capturar el argumento pasado al método crearCuentaParaStaff
        ArgumentCaptor<CuentaDomain> captor = ArgumentCaptor.forClass(CuentaDomain.class);
        verify(adminPersistence, times(1)).crearCuentaParaStaff(captor.capture());

        // Verificar los valores de CuentaDomain
        CuentaDomain cuentaDomain = captor.getValue();
        assertEquals("1234567", cuentaDomain.getCiUsuario());
        assertEquals("DIEGO", cuentaDomain.getPassUsuario());
        assertEquals(staff1, cuentaDomain.getFkStaffLegal());
    }
}