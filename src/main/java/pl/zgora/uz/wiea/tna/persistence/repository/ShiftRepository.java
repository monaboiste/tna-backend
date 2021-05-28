package pl.zgora.uz.wiea.tna.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.TimeOfDay;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface ShiftRepository extends JpaRepository<ShiftEntity, Long> {

    Optional<ShiftEntity> findByDateAndTimeOfDay(Date date, TimeOfDay timeOfDay);
}
