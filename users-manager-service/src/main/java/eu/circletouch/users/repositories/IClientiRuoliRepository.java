package eu.circletouch.users.repositories;

import eu.circletouch.users.entities.IClientiRuoliEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClientiRuoliRepository extends JpaRepository<IClientiRuoliEntity, Integer> {
    List<IClientiRuoliEntity> findAllBybClientiId(Integer bClientiId);
}
