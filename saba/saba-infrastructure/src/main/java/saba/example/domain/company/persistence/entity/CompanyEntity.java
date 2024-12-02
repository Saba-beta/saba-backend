package saba.example.domain.company.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import saba.example.domain.company.persistence.entity.type.Address;
import saba.example.domain.company.persistence.entity.type.Information;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_company")
public class CompanyEntity {
    @Id
    private Integer id;

    private String name;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Embedded
    private Address address;

    @Embedded
    private Information information;
}
