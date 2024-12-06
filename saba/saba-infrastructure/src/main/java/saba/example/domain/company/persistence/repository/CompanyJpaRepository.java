package saba.example.domain.company.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saba.example.domain.company.persistence.entity.CompanyEntity;

@Repository
public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, Long> {
}
