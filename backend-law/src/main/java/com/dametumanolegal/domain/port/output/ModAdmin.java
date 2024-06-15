package com.dametumanolegal.domain.port.output;

import com.dametumanolegal.domain.CuentaDomain;
import com.dametumanolegal.domain.StaffLegalDomain;

public interface ModAdmin {
    void crearCuentaParaStaff(CuentaDomain cuentaDomain);
    CuentaDomain traerCuentaPorID(Long id);
    StaffLegalDomain traerStaffPorId(Long id);
}
