package saba.example.domain.company.persistence.entity.type;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Contact {
    private String contactNumber;
    private String email;
}
