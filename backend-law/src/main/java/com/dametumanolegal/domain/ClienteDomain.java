package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDomain {
    private Long id;

    private StaffLegalDomain fkStaffLegal;

}
