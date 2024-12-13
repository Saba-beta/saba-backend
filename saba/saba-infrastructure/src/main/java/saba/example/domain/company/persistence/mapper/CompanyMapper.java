package saba.example.domain.company.persistence.mapper;

import org.springframework.stereotype.Component;
import saba.example.domain.company.model.Company;
import saba.example.domain.company.persistence.entity.CompanyEntity;
import saba.example.domain.company.persistence.entity.type.*;
@Component
public class CompanyMapper {
    public CompanyEntity toEntity(Company company){
        return CompanyEntity.builder()
                .id(company.getId())
                .contact(Contact.builder()
                        .email(company.getEmail())
                        .contactNumber(company.getContactNumber())
                        .build())
                .basicInfo(BasicInfo.builder()
                        .name(company.getName())
                        .status(company.getStatus())
                        .build())
                .details(CompanyDetails.builder()
                        .ceoName(company.getCeoName())
                        .descripteion(company.getDescription())
                        .employeeCount(company.getEmployeeCount())
                        .foundedDate(company.getFoundedDate())
                        .industryType(company.getIndustryType())
                        .logoUrl(company.getLogoUrl())
                        .websiteUrl(company.getWebsiteUrl())
                        .build())
                .date(Date.builder()
                        .createdAt(company.getCreatedAt())
                        .updatedAt(company.getUpdatedAt())
                        .build())
                .address(Address.builder()
                        .mainAddress(company.getMainAddress())
                        .mainZipCode(company.getMainZipCode())
                        .mainAddressDetail(company.getMainAddressDetail())
                        .build())
                .build();

    }

    public Company toDomain(CompanyEntity companyEntity) {
        return Company.builder()
                .id(companyEntity.getId())
                .email(companyEntity.getContact().getEmail())
                .contactNumber(companyEntity.getContact().getContactNumber())
                .name(companyEntity.getBasicInfo().getName())
                .status(companyEntity.getBasicInfo().getStatus())
                .ceoName(companyEntity.getDetails().getCeoName())
                .description(companyEntity.getDetails().getDescripteion())
                .employeeCount(companyEntity.getDetails().getEmployeeCount())
                .foundedDate(companyEntity.getDetails().getFoundedDate())
                .industryType(companyEntity.getDetails().getIndustryType())
                .logoUrl(companyEntity.getDetails().getLogoUrl())
                .websiteUrl(companyEntity.getDetails().getWebsiteUrl())
                .createdAt(companyEntity.getDate().getCreatedAt())
                .updatedAt(companyEntity.getDate().getUpdatedAt())
                .mainAddress(companyEntity.getAddress().getMainAddress())
                .mainAddressDetail(companyEntity.getAddress().getMainAddressDetail())
                .mainZipCode(companyEntity.getAddress().getMainZipCode())
                .build();
    }

}
