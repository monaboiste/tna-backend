package pl.zgora.uz.wiea.tna.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;

@Repository
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecordEntity, Long> {
}
