package saba.example.domain.product.persistence.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import saba.example.domain.company.persistence.entity.type.Date;
import saba.example.domain.company.persistence.repository.CompanyJpaRepository;
import saba.example.domain.product.model.Product;
import saba.example.domain.product.persistence.entity.ProductEntity;
import saba.example.domain.product.persistence.entity.type.ProductDetails;
import saba.example.domain.product.persistence.entity.type.ProductInfo;
import saba.example.domain.product.persistence.entity.type.RegistrationInfo;

// TODO 오류 발생 예상
@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final CompanyJpaRepository companyJpaRepository;
    public ProductEntity toEntity(Product product){
        return ProductEntity
                .builder()
                .id(product.getId())
                .productInfo(ProductInfo.builder()
                        .productImageUrl(product.getProductImageUrl())
                        .prise(product.getPrice())
                        .origin(product.getOrigin())
                        .type(product.getType())
                        .build())
                .details(ProductDetails.builder()
                        .DetailsImageUrl(product.getDetailsImageUrl())
                        .content(product.getContent())
                        .build())
                .registration(RegistrationInfo.builder()
                        .registrationAt(product.getRegistrationAt())
                        .company(companyJpaRepository.getReferenceById(product.getCompanyId()))
                        .build())
                .date(Date.builder()
                        .createdAt(product.getCreatedAt())
                        .updatedAt(product.getCreatedAt())
                        .build())
                .build();
    }
    public Product toDomain(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .productImageUrl(productEntity.getProductInfo().getProductImageUrl())
                .price(productEntity.getProductInfo().getPrise())
                .origin(productEntity.getProductInfo().getOrigin())
                .type(productEntity.getProductInfo().getType())
                .detailsImageUrl(productEntity.getDetails().getDetailsImageUrl())
                .content(productEntity.getDetails().getContent())
                .registrationAt(productEntity.getRegistration().getRegistrationAt())
                .companyId(productEntity.getRegistration().getCompany().getId()) // Company 객체의 ID 추출
                .createdAt(productEntity.getDate().getCreatedAt())
                .updatedAt(productEntity.getDate().getUpdatedAt())
                .build();
    }

}
