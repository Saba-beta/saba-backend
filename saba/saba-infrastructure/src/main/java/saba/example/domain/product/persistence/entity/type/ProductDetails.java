package saba.example.domain.product.persistence.entity.type;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.List;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class ProductDetails {
    @ElementCollection
    private List<String> DetailsImageUrl;
    @Column(columnDefinition = "TEXT")
    private String content;
}
