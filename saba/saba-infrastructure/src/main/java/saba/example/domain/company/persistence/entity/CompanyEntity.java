package saba.example.domain.company.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import saba.example.domain.company.persistence.entity.type.BasicInfo;
import saba.example.domain.company.persistence.entity.type.Contact;
import saba.example.domain.company.persistence.entity.type.Date;
import saba.example.domain.company.persistence.entity.type.Details;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_company")
public class CompanyEntity {
    @Id
    private Integer id;

    // basicInfo
    private BasicInfo basicInfo;
    // details
    private Details details;
    // contact
    private Contact contact;
    // date
    private Date date;
}
