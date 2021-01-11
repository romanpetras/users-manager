package eu.circletouch.users.repositories;

import eu.circletouch.users.entities.CompanyRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompaniesRolesRepository extends JpaRepository<CompanyRoleEntity, Integer> {
    List<CompanyRoleEntity> findAllByCompanyId(Integer companyId);
    List<CompanyRoleEntity> findAllByRoleId(Integer roleId);
}
