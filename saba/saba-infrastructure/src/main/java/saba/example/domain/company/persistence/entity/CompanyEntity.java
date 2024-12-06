package saba.example.domain.company.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import saba.example.domain.company.persistence.entity.type.BasicInfo;
import saba.example.domain.company.persistence.entity.type.Contact;
import saba.example.domain.company.persistence.entity.type.Date;
import saba.example.domain.company.persistence.entity.type.CompanyDetails;
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
    private Long id;
    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductEntity> products;
    private BasicInfo basicInfo;
    private CompanyDetails details;
    private Contact contact;
    private Date date;
}
