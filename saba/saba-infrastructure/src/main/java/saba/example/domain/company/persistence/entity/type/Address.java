package saba.example.domain.company.persistence.entity.type;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Addres {
    @NotNull
    @Column(columnDefinition = "VARCHAR(50)")
    private String mainAddress;

    @NotNull
    @Column(columnDefinition = "VARCHAR(50)")
    private String mainAddressDetail;

    @Column(columnDefinition = "VARCHAR(5)", nullable = false)
    private String mainZipCode;
}
