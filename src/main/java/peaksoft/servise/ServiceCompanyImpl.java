package peaksoft.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.DaoCompany;
import peaksoft.entity.Company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCompanyImpl implements ServiceCompany {

    private DaoCompany daoCompany;

    @Autowired
    public ServiceCompanyImpl(DaoCompany daoCompany) {
        this.daoCompany = daoCompany;
    }

    @Transactional
    @Override
    public void saveCompany(Company company) {
        daoCompany.saveCompany(company);
    }

    @Transactional
    @Override
    public void removeCompanyById(int id) {
        daoCompany.removeCompanyById(id);
    }

    @Transactional
    @Override
    public Company getById(int id) {

        return daoCompany.getCompanyById(id);
    }

    @Transactional
    @Override
    public List<Company> getAllCompany() {
        return daoCompany.getAllCompany();
    }

    @Transactional
    @Override
    public void update(int id, Company company) {
        daoCompany.update(id, company);

    }
}
