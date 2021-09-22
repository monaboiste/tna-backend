package pl.zgora.uz.wiea.tna.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zgora.uz.wiea.tna.model.AttendanceRecord;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AttendanceRecordUtils {

    public static AttendanceRecord mapAttendanceRecordEntityToAttendanceRecord(
            final AttendanceRecordEntity attendanceRecordEntity) {
        final EmployeeEntity employeeEntity = attendanceRecordEntity.getEmployeeEntity();

        return AttendanceRecord.builder()
                .id(attendanceRecordEntity.getId())
                .employeeId(employeeEntity != null ? employeeEntity.getId() : null)
                .shiftId(attendanceRecordEntity.getShiftEntity().getId())
                .enteredAt(attendanceRecordEntity.getEnteredAt())
                .leftAt(attendanceRecordEntity.getLeftAt())
                .elapsedTimePerShiftInMinutes(attendanceRecordEntity.getElapsedTimePerShiftInMinutes())
                .build();
    }

    public static AttendanceRecordEntity mapAttendanceRecordToEntity(final AttendanceRecord attendanceRecord) {
        return AttendanceRecordEntity.builder()
                .id(attendanceRecord.getId())
                .employeeEntity(EmployeeEntity.builder()
                        .id(attendanceRecord.getEmployeeId())
                        .build())
                .shiftEntity(ShiftEntity.builder()
                        .id(attendanceRecord.getShiftId())
                        .build())
                .enteredAt(attendanceRecord.getEnteredAt())
                .leftAt(attendanceRecord.getLeftAt())
                .elapsedTimePerShiftInMinutes(attendanceRecord.getElapsedTimePerShiftInMinutes())
                .build();
    }
}
