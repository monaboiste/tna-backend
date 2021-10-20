package pl.zgora.uz.wiea.tna.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;

import java.util.List;

@Repository
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecordEntity, Long> {

    @Override
    @Query("SELECT ar FROM AttendanceRecordEntity ar")
    @NonNull List<AttendanceRecordEntity> findAll();

    List<AttendanceRecordEntity> findByEmployeeEntityId(long employeeId);
}
