package saba.example.domain.product.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;
import saba.example.domain.company.model.Company;
import saba.example.domain.product.model.type.ProductType;

import java.time.LocalDateTime;
import java.util.List;

import java.time.LocalDate;

@Aggregate
@Builder(toBuilder = true)
@Getter
public class Product {
    private Long id;

    // productInfo
    private String productname;
    private ProductType type;
    private String origin;
    private Long prise;
    private List<String> productImageUrl;

    // registrationInfo
    private LocalDate registrationAt;
    private Company company;

    // detalils
    private List<String> DetailsImageUrl;
    private String content;

    // date
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
