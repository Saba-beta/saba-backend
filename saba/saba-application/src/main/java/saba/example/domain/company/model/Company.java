package saba.example.domain.company.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;
import saba.example.domain.company.model.type.Status;

import java.time.LocalDateTime;


// TODO 컬럼 정의
@Aggregate
@Builder(toBuilder = true)
@Getter
public class Company {
    private Integer id;
    private String name;
    private String registrationNumber;
    private String industryType;

    // address
    private String address;
    private String contactNumber;
    private String email;

    // information
    private LocalDateTime foundedDate;
    private String ceoName;
    private Integer employeeCount;
    private Status status; // ACTIVE, INACTIVE
    private String webUrl;
    private String logoUrl;
    private String descripteion;

    // fixedDate
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}