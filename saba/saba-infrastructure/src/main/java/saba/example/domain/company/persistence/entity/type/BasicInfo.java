package saba.example.domain.company.persistence.entity.type;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saba.example.domain.company.model.type.Status;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BasicInfo {
    private String name;
    private String registrationNumber;
    private String address;
    private Status status; // ACTIVE, INACTIVE

}
