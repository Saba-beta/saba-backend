package saba.example.domain.product.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saba.example.domain.product.persistence.mapper.ProductMapper;

public interface ProductJpaRepository extends JpaRepository<ProductMapper, Long> {
}
