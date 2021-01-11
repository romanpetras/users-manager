package eu.circletouch.users.services;

import eu.circletouch.commons.beans.BrowseRequest;
import eu.circletouch.commons.beans.BrowseResponse;
import eu.circletouch.users.beans.Company;
import eu.circletouch.users.beans.CompanyRole;
import eu.circletouch.users.beans.User;
import eu.circletouch.users.entities.CompanyRoleEntity;
import eu.circletouch.users.entities.RoleEntity;
import eu.circletouch.users.exceptions.CustomException;
import eu.circletouch.users.repositories.CompaniesRolesRepository;
import eu.circletouch.users.repositories.RolesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    private final RolesRepository rolesRepository;
    private final CompaniesRolesRepository companiesRolesRepository;

    public RolesService(RolesRepository rolesRepository, CompaniesRolesRepository companiesRolesRepository) {
        this.rolesRepository = rolesRepository;
        this.companiesRolesRepository = companiesRolesRepository;
    }

    public CompanyRole get(Integer id, User req) {
        Optional<RoleEntity> optionalRoleEntity = rolesRepository.findById(id);
        if (optionalRoleEntity.isPresent()) {
            RoleEntity roleEntity = optionalRoleEntity.get();
            return getCompanyRole(roleEntity);
        } else {
            throw new CustomException("Role not found for id " + id, HttpStatus.NOT_FOUND);
        }
    }

    public BrowseResponse<CompanyRole> browse(BrowseRequest browseRequest, User req) {
        return null;
    }

    public CompanyRole create(CompanyRole companyRole, User req) {
        Optional<RoleEntity> firstByCode = rolesRepository.findFirstByCode(companyRole.getCode());
        if (firstByCode.isPresent()) {
            throw new CustomException("Role already exists for code " + companyRole.getCode(), HttpStatus.BAD_REQUEST);
        }

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setCode(companyRole.getCode());
        roleEntity.setDescription(companyRole.getDescription());
        roleEntity.setCreatedById(req.getId());
        roleEntity.setCreatedByUser(req.getUsername());
        roleEntity = rolesRepository.save(roleEntity);
        return get(roleEntity.getId(), req);
    }

    public CompanyRole update(Integer id, CompanyRole companyRole, User req) {
        Optional<RoleEntity> optionalRoleEntity = rolesRepository.findById(id);
        if (optionalRoleEntity.isPresent()) {
            RoleEntity roleEntity = optionalRoleEntity.get();
            roleEntity.setCode(companyRole.getCode());
            roleEntity.setDescription(companyRole.getDescription());
            roleEntity.setUpdatedById(req.getId());
            roleEntity.setUpdatedByUser(req.getUsername());
            roleEntity = rolesRepository.save(roleEntity);
            return get(id, req);
        } else {
            throw new CustomException("Role not found for id " + id, HttpStatus.NOT_FOUND);
        }
    }

    public void delete(Integer id, User req) {
        Optional<RoleEntity> optionalRoleEntity = rolesRepository.findById(id);
        if (optionalRoleEntity.isPresent()) {
            List<CompanyRoleEntity> allByRoleId = companiesRolesRepository.findAllByRoleId(id);
            if (allByRoleId.size() > 0) {
                throw new CustomException("Role in use", HttpStatus.PRECONDITION_REQUIRED);
            } else {
                rolesRepository.deleteById(id);
            }
        } else {
            throw new CustomException("Role not found for id " + id, HttpStatus.NOT_FOUND);
        }
    }

    protected CompanyRole getCompanyRole(RoleEntity roleEntity) {
        CompanyRole companyRole = new CompanyRole();
        companyRole.setId(roleEntity.getId());
        companyRole.setCode(roleEntity.getCode());
        companyRole.setDescription(roleEntity.getDescription());
        return companyRole;
    }
}
