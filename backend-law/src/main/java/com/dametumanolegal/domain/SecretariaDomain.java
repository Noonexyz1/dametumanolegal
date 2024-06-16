package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecretariaDomain {
    private Long id;

    private StaffLegalDomain fkStaffLegal;
}
