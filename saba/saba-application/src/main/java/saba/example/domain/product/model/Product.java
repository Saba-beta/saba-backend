package saba.example.domain.product.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;
import saba.example.domain.company.model.Company;
import saba.example.domain.product.model.type.ProductType;
import java.util.List;

import java.time.LocalDate;

@Aggregate
@Builder(toBuilder = true)
@Getter
public class Product {
    private String pruductNumber;

    //상품 정보
    private String productname;
    private ProductType type;
    private String origin;
    private Long prise;
    private List<String> productImageUrl;

    // 등록 정보
    private LocalDate registrationAt;
    private Company company;

    // 상세 정보
    private List<String> DetailsImageUrl;
}
