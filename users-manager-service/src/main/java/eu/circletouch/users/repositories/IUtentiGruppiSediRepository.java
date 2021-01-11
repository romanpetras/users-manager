package eu.circletouch.users.repositories;

import eu.circletouch.users.entities.IUtentiGruppiSediEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUtentiGruppiSediRepository extends JpaRepository<IUtentiGruppiSediEntity, Integer> {
    List<IUtentiGruppiSediEntity> findAllByBUtentiIdAndBSediId(Integer bUtentiId, Integer bSediId);
    List<IUtentiGruppiSediEntity> findAllByBUtentiId(Integer bUtentiId);
}
