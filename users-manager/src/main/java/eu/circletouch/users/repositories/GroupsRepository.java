package eu.circletouch.users.repositories;

import eu.circletouch.users.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupsRepository extends JpaRepository<GroupEntity, Integer> {
    Optional<GroupEntity> findFirstByCode(String code);
}
