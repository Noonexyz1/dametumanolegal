package com.dametumanolegal.domain;

import com.dametumanolegal.domain.ports.Cuentable;
import com.dametumanolegal.domain.ports.Rolable;

public class Abogado extends StaffLegal implements Rolable, Cuentable {
    private boolean isAdmin;

}
