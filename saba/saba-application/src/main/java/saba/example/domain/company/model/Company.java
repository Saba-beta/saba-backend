package saba.example.domain.company.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;
import saba.example.domain.company.model.type.Status;
import java.time.LocalDateTime;


@Aggregate
@Builder(toBuilder = true)
@Getter
public class Company {

    // basicInfo
    private String name;
    private String registrationNumber;
    private String address;
    private Status status; // ACTIVE, INACTIVE

    // details
    private String industryType;
    private LocalDateTime foundedDate;
    private String ceoName;
    private Integer employeeCount;
    private String websiteUrl;
    private String logoUrl;
    private String descripteion;

    // contact
    private String contactNumber;
    private String email;

    // date
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}