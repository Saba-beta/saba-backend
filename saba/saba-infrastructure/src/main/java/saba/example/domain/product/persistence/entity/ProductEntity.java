package saba.example.domain.product.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import saba.example.domain.product.persistence.entity.type.ProductDetails;
import saba.example.domain.product.persistence.entity.type.ProductInfo;
import saba.example.domain.product.persistence.entity.type.RegistrationInfo;


@Entity
@Table(name = "tbl_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProductEntity {
    @Id
    private Long id;

    @Embedded
    private ProductInfo productInfo;

    @Embedded
    private RegistrationInfo registration;

    @Embedded
    private ProductDetails details;
}
