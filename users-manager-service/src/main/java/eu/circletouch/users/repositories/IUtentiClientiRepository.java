package eu.circletouch.users.repositories;

import eu.circletouch.users.entities.IUtentiClientiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUtentiClientiRepository extends JpaRepository<IUtentiClientiEntity, Integer> {
    List<IUtentiClientiEntity> findAllBybUtentiId(Integer bUtentiId);
    List<IUtentiClientiEntity> findAllBybClientiId(Integer bClientiId);
}
