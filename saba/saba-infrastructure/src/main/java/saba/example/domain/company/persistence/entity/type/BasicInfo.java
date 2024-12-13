package saba.example.domain.company.persistence.entity.type;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import saba.example.domain.company.model.type.Status;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BasicInfo {
    @Column(columnDefinition = "VARCHAR(30)")
    @NotNull
    private String name;
    @NotNull
    private Status status; // ACTIVE, INACTIVE
}
