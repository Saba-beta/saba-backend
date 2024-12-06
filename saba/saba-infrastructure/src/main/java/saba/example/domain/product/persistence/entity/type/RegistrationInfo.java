package saba.example.domain.product.persistence.entity.type;

import jakarta.persistence.*;
import lombok.*;
import saba.example.domain.company.persistence.entity.CompanyEntity;
import java.time.LocalDate;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class RegistrationInfo {
    private LocalDate registrationAt;
    @JoinColumn(name = "company_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CompanyEntity company;
}
