package saba.example.domain.product.persistence.entity.type;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDetails {
    @ElementCollection
    private List<String> DetailsImageUrl;
    @Column(columnDefinition = "TEXT")
    private String content;
}
