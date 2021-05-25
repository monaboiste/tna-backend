package pl.zgora.uz.wiea.tna.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zgora.uz.wiea.tna.model.AttendanceRecord;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class AttendanceRecordUtils {

    static public AttendanceRecord mapAttendanceRecordEntityToAttendanceRecord(
            final AttendanceRecordEntity attendanceRecordEntity) {
        return AttendanceRecord.builder()
                .id(attendanceRecordEntity.getId())
                .employeeId(attendanceRecordEntity.getEmployeeEntity().getUserId())
                .shiftId(attendanceRecordEntity.getShiftEntity().getId())
                .enteredAt(attendanceRecordEntity.getEnteredAt())
                .leftAt(attendanceRecordEntity.getLeftAt())
                .elapsedTimePerShiftInMinutes(attendanceRecordEntity.getElapsedTimePerShiftInMinutes())
                .build();
    }

    static public AttendanceRecordEntity mapAttendanceRecordToEntity(final AttendanceRecord attendanceRecord) {
        return AttendanceRecordEntity.builder()
                .id(attendanceRecord.getId())
                .employeeEntity(EmployeeEntity.builder().userId(attendanceRecord.getEmployeeId()).build())
                .shiftEntity(ShiftEntity.builder().id(attendanceRecord.getShiftId()).build())
                .enteredAt(attendanceRecord.getEnteredAt())
                .leftAt(attendanceRecord.getLeftAt())
                .elapsedTimePerShiftInMinutes(attendanceRecord.getElapsedTimePerShiftInMinutes())
                .build();
    }
}
