package peaksoft.dao;

import peaksoft.entity.Company;

import java.util.List;

public interface DaoCompany {

    void saveCompany(Company company);

    void removeCompanyById(int id);

    Company getCompanyById(int id);

    List<Company> getAllCompany();

    void update(int id,Company company);
}
