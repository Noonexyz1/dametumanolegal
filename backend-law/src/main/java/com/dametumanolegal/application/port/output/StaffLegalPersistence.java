package com.dametumanolegal.application.port.output;

import com.dametumanolegal.application.datacarries.CuentaDataCarrier;
import com.dametumanolegal.application.datacarries.SesionDataCarrier;
import com.dametumanolegal.domain.model.CuentaDomain;
import com.dametumanolegal.domain.model.SesionDomain;

public interface StaffLegalPersistence {
    CuentaDataCarrier buscarPorUserYPass(String ci, String pass);
    SesionDataCarrier crearSesion(SesionDataCarrier sesionDomain);
    void actualizar(CuentaDataCarrier cuentaDomain);
}
