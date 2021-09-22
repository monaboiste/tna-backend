package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zgora.uz.wiea.tna.model.AttendanceRecord;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;
import pl.zgora.uz.wiea.tna.service.AttendanceRecordService;
import pl.zgora.uz.wiea.tna.util.AttendanceRecordUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceRecordController {

    private final AttendanceRecordService attendanceRecordService;

    @PostMapping
    public AttendanceRecord createAttendanceRecord(
            @RequestBody @Valid final AttendanceRecord attendanceRecord) {
        final AttendanceRecordEntity attendanceRecordEntity
                = AttendanceRecordUtils.mapAttendanceRecordToEntity(attendanceRecord);
        return AttendanceRecordUtils.mapAttendanceRecordEntityToAttendanceRecord(
                attendanceRecordService.createAttendanceRecord(attendanceRecordEntity));
    }

    @GetMapping
    public List<AttendanceRecord> fetchAllAttendanceRecords() {
        final List<AttendanceRecordEntity> attendanceRecordEntities
                = attendanceRecordService.fetchAllAttendanceRecords();
        return attendanceRecordEntities.parallelStream()
                .map(AttendanceRecordUtils::mapAttendanceRecordEntityToAttendanceRecord)
                .collect(Collectors.toList());
    }
}
