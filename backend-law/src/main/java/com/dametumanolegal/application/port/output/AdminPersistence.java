package com.dametumanolegal.application.port.output;

import com.dametumanolegal.domain.model.CuentaDomain;
import com.dametumanolegal.domain.model.StaffLegalDomain;

public interface AdminPersistence {
    void crearCuentaParaStaff(CuentaDomain cuentaDomain);
    CuentaDomain traerCuentaPorID(Long id);
    StaffLegalDomain traerStaffPorId(Long id);
}
