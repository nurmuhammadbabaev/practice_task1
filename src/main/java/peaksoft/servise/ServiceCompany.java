package peaksoft.servise;

import org.springframework.stereotype.Service;
import peaksoft.entity.Company;

import java.util.List;

public interface ServiceCompany {
    void saveCompany(Company company);

    void removeCompanyById(int id);

    Company getById(int id);

    List<Company> getAllCompany();

    void update(int id,Company company);

}
