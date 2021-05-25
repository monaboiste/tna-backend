package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.AttendanceRecordRepository;
import pl.zgora.uz.wiea.tna.persistence.repository.EmployeeRepository;
import pl.zgora.uz.wiea.tna.persistence.repository.ShiftRepository;
import pl.zgora.uz.wiea.tna.service.exception.ShiftNotFoundException;
import pl.zgora.uz.wiea.tna.service.exception.UserNotFoundException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AttendanceRecordService {

    private final AttendanceRecordRepository attendanceRecordRepository;
    private final EmployeeRepository employeeRepository;
    private final ShiftRepository shiftRepository;

    @Transactional
    public AttendanceRecordEntity createAttendanceRecord(AttendanceRecordEntity attendanceRecordEntity) {
        final long employeeId = attendanceRecordEntity.getEmployeeEntity().getId();
        final long shiftId = attendanceRecordEntity.getShiftEntity().getId();

        final EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(UserNotFoundException::new);
        final ShiftEntity shiftEntity = shiftRepository.findById(shiftId)
                .orElseThrow(ShiftNotFoundException::new);

        final long elapsedTimePerShift = calculateElapsedTimePerShift(attendanceRecordEntity);
        attendanceRecordEntity.setElapsedTimePerShiftInMinutes(elapsedTimePerShift);
        attendanceRecordEntity.setEmployeeEntity(employeeEntity);
        attendanceRecordEntity.setShiftEntity(shiftEntity);

        return attendanceRecordRepository.saveAndFlush(attendanceRecordEntity);
    }

    private long calculateElapsedTimePerShift(final AttendanceRecordEntity attendanceRecordEntity) {
        long differenceInMinutes = 0L;
        if (Objects.nonNull(attendanceRecordEntity.getLeftAt())) {
            final long started = attendanceRecordEntity.getEnteredAt().toEpochSecond();
            final long ended = attendanceRecordEntity.getLeftAt().toEpochSecond();
            differenceInMinutes = (ended - started) / 60;
        }
        return Math.max(differenceInMinutes, 0L);
    }
}
