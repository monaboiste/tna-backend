package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.zgora.uz.wiea.tna.model.AttendanceRecord;
import pl.zgora.uz.wiea.tna.model.AttendanceRecordEntryTime;
import pl.zgora.uz.wiea.tna.model.AttendanceRecordExitTime;
import pl.zgora.uz.wiea.tna.model.Employee;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.service.AttendanceRecordService;
import pl.zgora.uz.wiea.tna.service.EmployeeService;
import pl.zgora.uz.wiea.tna.util.AttendanceRecordUtils;
import pl.zgora.uz.wiea.tna.util.EmployeeUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AttendanceRecordService attendanceRecordService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Employee createEmployee(@RequestBody @Valid final Employee employee) {
        final EmployeeEntity employeeEntity = employeeService.createEmployee(
                EmployeeUtils.mapEmployeeToEntity(employee));
        return EmployeeUtils.mapEmployeeEntityToEmployee(employeeEntity);
    }

    @GetMapping
    public List<Employee> fetchAllEmployees() {
        final List<EmployeeEntity> employeeEntities = employeeService.fetchAllEmployees();
        final List<Employee> employees = employeeEntities.parallelStream()
                .map(EmployeeUtils::mapEmployeeEntityToEmployee)
                .collect(Collectors.toList());
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Employee fetchEmployeeById(@PathVariable long employeeId) {
        final EmployeeEntity employeeEntity = employeeService.fetchEmployeeById(employeeId);
        return EmployeeUtils.mapEmployeeEntityToEmployee(employeeEntity);
    }

    @GetMapping("/{employeeId}/attendance")
    public List<AttendanceRecord> fetchAllEmployeesAttendanceRecords(@PathVariable long employeeId) {
        final List<AttendanceRecordEntity> attendanceRecordEntities
                = attendanceRecordService.fetchAllAttendanceRecordsByEmployeeId(employeeId);
        final List<AttendanceRecord> attendanceRecords = attendanceRecordEntities.parallelStream()
                .map(AttendanceRecordUtils::mapAttendanceRecordEntityToAttendanceRecord)
                .collect(Collectors.toList());

        return attendanceRecords;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{employeeId}/attendance/{attendanceId}/entry-time")
    public AttendanceRecord updateEntryTime(
            @PathVariable long employeeId,
            @PathVariable("attendanceId") long attendanceId,
            @RequestBody @Valid final AttendanceRecordEntryTime attendanceRecordEntryTime) {
        return AttendanceRecordUtils.mapAttendanceRecordEntityToAttendanceRecord(
                attendanceRecordService.updateEntryTime(
                        employeeId,
                        attendanceId,
                        attendanceRecordEntryTime.getEnteredAt()
                ));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{employeeId}/attendance/{attendanceId}/exit-time")
    public AttendanceRecord updateExitTime(
            @PathVariable long employeeId,
            @PathVariable("attendanceId") long attendanceId,
            @RequestBody @Valid final AttendanceRecordExitTime attendanceRecordExitTime) {
        return AttendanceRecordUtils.mapAttendanceRecordEntityToAttendanceRecord(
                attendanceRecordService.updateExitTime(
                        employeeId,
                        attendanceId,
                        attendanceRecordExitTime.getLeftAt()
                ));
    }
}
