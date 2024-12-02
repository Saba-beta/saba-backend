package saba.example.domain.company.persistence.entity.type;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saba.example.domain.company.model.type.Status;

import java.time.LocalDateTime;

// TODO 불쾌함: 분리 고려할 것
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Information {
    private String industryType;
    private LocalDateTime foundedDate;
    private String ceoName;
    private Integer employeeCount;
    private Status status; // ACTIVE, INACTIVE
    private String websiteUrl;
    private String logoUrl;
    private String descripteion;
}
