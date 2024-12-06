package saba.example.domain.company.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import saba.example.common.annotation.Adapter;
import saba.example.domain.company.model.Company;
import saba.example.domain.company.persistence.mapper.CompanyMapper;
import saba.example.domain.company.persistence.repository.CompanyJpaRepository;
import saba.example.domain.company.spi.CompanyPort;

import java.util.List;

import static saba.example.domain.company.persistence.entity.QCompanyEntity.companyEntity;
import static saba.example.domain.product.persistence.entity.QProductEntity.productEntity;

@Adapter
@RequiredArgsConstructor
public class CompanyPersistenceAdapter implements CompanyPort {
    private final CompanyJpaRepository companyJpaRepository;
    private final CompanyMapper mapper;
    private final JPAQueryFactory queryFactory;

    @Override
    public Company save(Company company) {
        return mapper.toDomain(
                companyJpaRepository.save(
                        mapper.toEntity(company)));
    }

    @Override
    public void saveAll(List<Company> companies) {
        companyJpaRepository.saveAll(
                companies.stream()
                        .map(mapper::toEntity)
                        .toList()
        );
    }

    @Override
    public Long totalCompanyCount() {
        return queryFactory
                .select(companyEntity.count())
                .from(companyEntity)
                .where().fetchOne();
    }
}
