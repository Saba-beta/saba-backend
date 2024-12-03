package saba.example.domain.company.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import saba.example.domain.company.persistence.entity.type.BasicInfo;
import saba.example.domain.company.persistence.entity.type.Contact;
import saba.example.domain.company.persistence.entity.type.Date;
import saba.example.domain.company.persistence.entity.type.CompanyDetails;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_company")
public class CompanyEntity {
    @Id
    private Integer id;

    private BasicInfo basicInfo;

    private CompanyDetails details;

    private Contact contact;

    private Date date;
}
