package saba.example.domain.company.persistence.entity.type;

import jakarta.persistence.Embeddable;
import lombok.*;
import saba.example.domain.company.model.type.Status;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BasicInfo {
    private String name;
    private String address;
    private Status status; // ACTIVE, INACTIVE
}
