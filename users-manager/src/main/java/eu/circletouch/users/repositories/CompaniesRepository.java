package eu.circletouch.users.repositories;

import eu.circletouch.users.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompaniesRepository extends JpaRepository<CompanyEntity, Integer> {
    Optional<CompanyEntity> findFirstByCode(String code);
}
