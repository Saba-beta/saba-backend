package saba.example.domain.product.persistence.entity.type;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saba.example.domain.product.model.type.ProductType;
import java.util.List;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductInfo {
    private String productname;
    private ProductType type;
    private String origin;
    private Long prise;
    @ElementCollection
    private List<String> productImageUrl;
}
