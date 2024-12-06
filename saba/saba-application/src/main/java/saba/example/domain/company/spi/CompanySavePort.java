package saba.example.domain.company.spi;

import saba.example.domain.company.model.Company;
import java.util.List;

public interface CompanySavePort {
    Company save(Company company);
    void saveAll(List<Company> companies);

}
