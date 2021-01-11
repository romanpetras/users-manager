package eu.circletouch.users.repositories;

import eu.circletouch.users.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findFirstByCode(String code);
}
