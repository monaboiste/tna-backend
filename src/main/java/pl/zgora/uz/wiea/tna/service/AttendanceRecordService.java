package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.TimeOfDay;
import pl.zgora.uz.wiea.tna.persistence.repository.AttendanceRecordRepository;
import pl.zgora.uz.wiea.tna.service.exception.AttendanceNotFoundException;
import pl.zgora.uz.wiea.tna.service.exception.EmployeeNotFoundException;

import java.sql.Date;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AttendanceRecordService {

    private final AttendanceRecordRepository attendanceRecordRepository;
    private final EmployeeService employeeService;
    private final ShiftService shiftService;

    @Transactional
    public AttendanceRecordEntity createAttendanceRecord(AttendanceRecordEntity attendanceRecordEntity) {
        final long employeeId = attendanceRecordEntity.getEmployeeEntity().getId();
        final EmployeeEntity employeeEntity = employeeService.fetchEmployeeById(employeeId);

        // Find shiftId based off enteredAt time
        final Date date = Date.valueOf(attendanceRecordEntity.getEnteredAt().toLocalDate());
        final TimeOfDay timeOfDay = estimateTimeOfDay(attendanceRecordEntity.getEnteredAt());

        final ShiftEntity shiftEntity = shiftService.fetchShiftByDateAndTimeOfDay(date, timeOfDay)
                .orElse(ShiftEntity.builder()
                    .timeOfDay(timeOfDay)
                    .date(date)
                    .build());

        final long elapsedTimePerShift = calculateElapsedTimePerShift(attendanceRecordEntity);
        attendanceRecordEntity.setElapsedTimePerShiftInMinutes(elapsedTimePerShift);
        attendanceRecordEntity.setEmployeeEntity(employeeEntity);
        attendanceRecordEntity.setShiftEntity(shiftEntity);

        return attendanceRecordRepository.saveAndFlush(attendanceRecordEntity);
    }

    public List<AttendanceRecordEntity> fetchAllAttendanceRecordsByEmployeeId(final long employeeId) {
        List<AttendanceRecordEntity> attendanceRecordEntities
                = attendanceRecordRepository.findByEmployeeEntityId(employeeId);

        attendanceRecordEntities.parallelStream()
                .forEach(e -> {
                    long elapsedTimePerShift = calculateElapsedTimePerShift(e);
                    e.setElapsedTimePerShiftInMinutes(elapsedTimePerShift);
                });
        return attendanceRecordEntities;
    }

    public List<AttendanceRecordEntity> fetchAllAttendanceRecords() {
        List<AttendanceRecordEntity> attendanceRecordEntities = attendanceRecordRepository.findAll();

        attendanceRecordEntities.parallelStream()
                .forEach(e -> {
                    long elapsedTimePerShift = calculateElapsedTimePerShift(e);
                    e.setElapsedTimePerShiftInMinutes(elapsedTimePerShift);
                });
        return attendanceRecordEntities;
    }

    @Transactional
    public AttendanceRecordEntity updateEntryTime(long employeeId,
                                                  long attendanceId,
                                                  final OffsetDateTime enteredAt) {
        if (!employeeService.employeeExistsById(employeeId)) {
            throw new EmployeeNotFoundException();
        }

        AttendanceRecordEntity attendanceRecordEntity
                = attendanceRecordRepository.findById(attendanceId)
                    .orElseThrow(AttendanceNotFoundException::new);

        ShiftEntity shiftEntity = attendanceRecordEntity.getShiftEntity();
        final TimeOfDay timeOfDay = estimateTimeOfDay(enteredAt);
        shiftEntity.setTimeOfDay(timeOfDay);

        attendanceRecordEntity.setEnteredAt(enteredAt);
        long elapsedTimePerShift = calculateElapsedTimePerShift(attendanceRecordEntity);
        attendanceRecordEntity.setElapsedTimePerShiftInMinutes(elapsedTimePerShift);

        return attendanceRecordRepository.saveAndFlush(attendanceRecordEntity);
    }

    @Transactional
    public AttendanceRecordEntity updateExitTime(long employeeId,
                                                 long attendanceId,
                                                 final OffsetDateTime leftAt) {
        if (!employeeService.employeeExistsById(employeeId)) {
            throw new EmployeeNotFoundException();
        }

        AttendanceRecordEntity attendanceRecordEntity
                = attendanceRecordRepository.findById(attendanceId)
                    .orElseThrow(AttendanceNotFoundException::new);

        attendanceRecordEntity.setLeftAt(leftAt);
        long elapsedTimePerShift = calculateElapsedTimePerShift(attendanceRecordEntity);
        attendanceRecordEntity.setElapsedTimePerShiftInMinutes(elapsedTimePerShift);

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

    private TimeOfDay estimateTimeOfDay(final OffsetDateTime enteredAt) {
        final int hour = enteredAt.getHour();
        if (hour >= 4 && hour < 10) {
            return TimeOfDay.MORNING;
        }
        if (hour >= 10 && hour < 17) {
            return TimeOfDay.AFTERNOON;
        }
        if ((hour >= 17 && hour < 24) || (hour < 4)) {
            return TimeOfDay.NIGHT;
        }
        return null;
    }
}
