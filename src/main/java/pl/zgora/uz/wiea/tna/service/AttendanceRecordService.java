package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.AttendanceRecordRepository;
import pl.zgora.uz.wiea.tna.persistence.repository.EmployeeRepository;
import pl.zgora.uz.wiea.tna.persistence.repository.ShiftRepository;
import pl.zgora.uz.wiea.tna.service.exception.ShiftNotFoundException;
import pl.zgora.uz.wiea.tna.service.exception.UserNotFoundException;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AttendanceRecordService {

    private final AttendanceRecordRepository attendanceRecordRepository;
    private final EmployeeRepository employeeRepository;
    private final ShiftRepository shiftRepository;

    @Transactional
    public AttendanceRecordEntity createAttendanceRecord(AttendanceRecordEntity attendanceRecordEntity) {
        final long employeeId = attendanceRecordEntity.getEmployeeEntity().getUserId();
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
        final long started = attendanceRecordEntity.getEnteredAt().toEpochSecond();
        final long ended = attendanceRecordEntity.getLeftAt().toEpochSecond();
        final long differenceInMinutes = (ended - started) / 60;
        return differenceInMinutes < 0 ? 0 : differenceInMinutes;
    }
}
