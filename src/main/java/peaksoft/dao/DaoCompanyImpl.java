package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DaoCompanyImpl implements DaoCompany {

  @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveCompany(Company company) {
      entityManager.persist(company);
    }

    @Override
    public void removeCompanyById(int id) {

   entityManager.remove(getCompanyById(id));
    }

    @Override
    public Company getCompanyById(int id) {

        return entityManager.find(Company.class,id);
    }

    @Override
    public List<Company> getAllCompany() {
      List<Company>companyList=entityManager.createQuery("SELECT c from Company c",Company.class).getResultList();
        return companyList;
    }

    @Override
    public void update(int id, Company updateCompany) {
      Company company = getCompanyById(id);
      company.setCompanyName(updateCompany.getCompanyName());
      company.setLocatedCountry(updateCompany.getLocatedCountry());
      entityManager.merge(company);

    }
}
