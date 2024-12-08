package saba.example.domain.product.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import saba.example.domain.company.persistence.entity.CompanyEntity;
import saba.example.domain.company.persistence.entity.type.Date;
import saba.example.domain.product.persistence.entity.type.ProductDetails;
import saba.example.domain.product.persistence.entity.type.ProductInfo;
import saba.example.domain.product.persistence.entity.type.RegistrationInfo;


@Entity
@Table(name = "tbl_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "fk_company_product"))
    private CompanyEntity company;

    @Embedded
    private ProductInfo productInfo;
    @Embedded
    private RegistrationInfo registration;
    @Embedded
    private ProductDetails details;
    @Embedded
    private Date date;
}
