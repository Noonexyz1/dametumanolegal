package com.dametumanolegal.application.port.output;

import com.dametumanolegal.application.datacarries.CuentaDataCarrier;
import com.dametumanolegal.application.datacarries.StaffLegalDataCarrier;

public interface AdminPersistence {
    void crearCuentaParaStaff(CuentaDataCarrier cuentaDomain);
    CuentaDataCarrier traerCuentaPorID(Long id);
    StaffLegalDataCarrier traerStaffPorId(Long id);
}
