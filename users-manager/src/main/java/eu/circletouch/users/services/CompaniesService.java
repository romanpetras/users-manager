package eu.circletouch.users.services;

import eu.circletouch.commons.beans.BrowseRequest;
import eu.circletouch.commons.beans.BrowseResponse;
import eu.circletouch.users.beans.Company;
import eu.circletouch.users.beans.CompanyRole;
import eu.circletouch.users.beans.User;
import eu.circletouch.users.entities.CompanyEntity;
import eu.circletouch.users.entities.CompanyRoleEntity;
import eu.circletouch.users.entities.RoleEntity;
import eu.circletouch.users.exceptions.CustomException;
import eu.circletouch.users.repositories.CompaniesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompaniesService {

    private final CompaniesRepository companiesRepository;

    public CompaniesService(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    public Company get(Integer id, User req) {
        Optional<CompanyEntity> optionalCompaniesEntity = companiesRepository.findById(id);
        if (optionalCompaniesEntity.isPresent()) {
            CompanyEntity companyEntity = optionalCompaniesEntity.get();
            return getCompany(companyEntity);
        } else {
            throw new CustomException("Company not found for id " + id, HttpStatus.NOT_FOUND);
        }
    }

    public BrowseResponse<Company> browse(BrowseRequest browseRequest, User req) {
        return null;
    }

    public Company create(Company company, User req) {
        Optional<CompanyEntity> firstByCode = companiesRepository.findFirstByCode(company.getCode());
        if (firstByCode.isPresent()) {
            throw new CustomException("Company already exists for code " + company.getCode(), HttpStatus.BAD_REQUEST);
        }

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCode(company.getCode());
        companyEntity.setName(company.getName());
        companyEntity.setVatNumber(company.getVatNumber());
        companyEntity.setVatCountryCode(company.getVatCountryCode());
        companyEntity.setEnabled((byte) 1);
        companyEntity.setCreatedById(req.getId());
        companyEntity.setCreatedByUser(req.getUsername());
        companyEntity = companiesRepository.save(companyEntity);

        return get(companyEntity.getId(), req);
    }

    public Company update(Integer id, Company company, User req) {


        return null;
    }

    public void delete(Integer id, User req) {

    }

    protected Company getCompany(CompanyEntity companyEntity) {
        Company company = new Company();
        company.setId(Long.valueOf(companyEntity.getId()));
        company.setCode(companyEntity.getCode());
        company.setName(companyEntity.getName());
        company.setVatNumber(companyEntity.getVatNumber());
        company.setVatCountryCode(companyEntity.getVatCountryCode());

        for (CompanyRoleEntity companyRoleEntity : companyEntity.getCompanyRoles()) {
            RoleEntity roleEntity = companyRoleEntity.getRole();
            company.getCompanyRoles().add(getCompanyRole(roleEntity));
        }

        return company;
    }

    protected CompanyRole getCompanyRole(RoleEntity roleEntity) {
        CompanyRole companyRole = new CompanyRole();
        companyRole.setId(roleEntity.getId());
        companyRole.setCode(roleEntity.getCode());
        companyRole.setDescription(roleEntity.getDescription());
        return companyRole;
    }
}
