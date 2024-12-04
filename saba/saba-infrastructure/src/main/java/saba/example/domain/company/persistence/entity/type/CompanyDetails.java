package saba.example.domain.company.persistence.entity.type;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CompanyDetails {
    private String industryType;
    private LocalDateTime foundedDate;
    private String ceoName;
    private Integer employeeCount;
    private String websiteUrl;
    private String logoUrl;
    private String descripteion;
}
