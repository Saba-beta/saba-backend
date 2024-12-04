package saba.example.domain.product.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;
import saba.example.domain.product.model.type.ProductType;

import java.time.LocalDateTime;
import java.util.List;

import java.time.LocalDate;
// TODO 제품수량
@Aggregate
@Builder(toBuilder = true)
@Getter
public class Product {
    private Long id;

    // productInfo
    private String productName;
    private ProductType type;
    private String origin;
    private Long price;
    private List<String> productImageUrl;

    // registrationInfo
    private LocalDate registrationAt;
    private Long companyId;

    // detalils
    private List<String> detailsImageUrl;
    private String content;

    // date
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
