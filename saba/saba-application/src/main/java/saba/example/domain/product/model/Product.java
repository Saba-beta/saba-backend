package saba.example.domain.product.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;

@Aggregate
@Builder(toBuilder = true)
@Getter
public class Product {
    
}
