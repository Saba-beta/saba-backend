package saba.example.domain.product.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saba.example.domain.product.persistence.entity.ProductEntity;
import saba.example.domain.product.persistence.mapper.ProductMapper;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
