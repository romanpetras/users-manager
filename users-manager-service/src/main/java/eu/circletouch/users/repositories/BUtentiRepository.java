package eu.circletouch.users.repositories;

import eu.circletouch.users.entities.BUtentiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BUtentiRepository extends JpaRepository<BUtentiEntity, Integer> {
    Optional<BUtentiEntity> findFirstByCodutente(String codutente);
}
