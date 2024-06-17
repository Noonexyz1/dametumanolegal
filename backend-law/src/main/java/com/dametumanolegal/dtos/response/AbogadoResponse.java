package com.dametumanolegal.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbogadoResponse {
    private Long idAbogado;
    //private boolean isAdmin;
    private StaffLegalResponse fkStaffLegal;
}
