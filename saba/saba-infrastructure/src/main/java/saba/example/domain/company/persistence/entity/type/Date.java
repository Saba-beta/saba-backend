package saba.example.domain.company.persistence.entity.type;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Date {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
