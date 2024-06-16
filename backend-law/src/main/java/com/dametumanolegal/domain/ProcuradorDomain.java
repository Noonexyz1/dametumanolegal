package com.dametumanolegal.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcuradorDomain {
    private Long id;

    private StaffLegalDomain fkStaffLegal;

}
