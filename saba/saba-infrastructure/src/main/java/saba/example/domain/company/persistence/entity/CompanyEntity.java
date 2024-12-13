package saba.example.domain.company.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import saba.example.domain.company.persistence.entity.type.*;
import saba.example.domain.company.persistence.entity.type.Date;
import saba.example.domain.product.persistence.entity.ProductEntity;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_company")
@Builder
@Getter
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<ProductEntity> products;

    @Embedded
    private BasicInfo basicInfo;

    @Embedded
    private CompanyDetails details;

    @Embedded
    private Contact contact;

    @Embedded
    private Date date;

    @Embedded
    private Address address;
}
