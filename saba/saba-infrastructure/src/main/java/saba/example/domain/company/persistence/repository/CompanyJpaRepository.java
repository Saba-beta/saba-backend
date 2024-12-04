package saba.example.domain.company.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saba.example.domain.company.persistence.entity.CompanyEntity;

public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, Long> {
}
