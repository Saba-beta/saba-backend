package saba.example.domain.company.uescase;

import lombok.RequiredArgsConstructor;
import saba.example.common.annotation.UseCase;
import saba.example.domain.company.spi.CompanyPort;

@UseCase
@RequiredArgsConstructor
public class RegistCompany {
    private final CompanyPort companyPort;


}
