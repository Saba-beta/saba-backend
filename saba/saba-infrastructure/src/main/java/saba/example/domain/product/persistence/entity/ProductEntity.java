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
    private Long id;;
    @Embedded
    private ProductInfo productInfo;
    @Embedded
    private RegistrationInfo registration;
    @Embedded
    private ProductDetails details;
    @Embedded
    private Date date;
}
