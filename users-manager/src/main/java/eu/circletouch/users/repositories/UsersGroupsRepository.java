package eu.circletouch.users.repositories;

import eu.circletouch.users.entities.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersGroupsRepository extends JpaRepository<UserGroupEntity, Integer> {
    List<UserGroupEntity> findAllByUserId(Integer userId);
    List<UserGroupEntity> findAllByGroupId(Integer groupId);
}
