package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.zgora.uz.wiea.tna.model.AttendanceRecord;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;
import pl.zgora.uz.wiea.tna.service.AttendanceRecordService;
import pl.zgora.uz.wiea.tna.util.AttendanceRecordUtils;


@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceRecordController {

    private final AttendanceRecordService attendanceRecordService;

    @PostMapping
    public AttendanceRecord createAttendanceRecord(
            @RequestBody final AttendanceRecord attendanceRecord) {
        final AttendanceRecordEntity attendanceRecordEntity = AttendanceRecordUtils.mapAttendanceRecordToEntity(attendanceRecord);
        return AttendanceRecordUtils.mapAttendanceRecordEntityToAttendanceRecord(
                attendanceRecordService.createAttendanceRecord(attendanceRecordEntity));
    }
    
}
