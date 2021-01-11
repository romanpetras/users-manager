package eu.circletouch.users.repositories;

import eu.circletouch.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findFirstByUsername(String username);
}
