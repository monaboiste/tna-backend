package pl.zgora.uz.wiea.tna.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import pl.zgora.uz.wiea.tna.persistence.entity.AttendanceRecordEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.AttendanceRecordRepository;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class AttendanceRecordServiceTest {

    @Mock
    AttendanceRecordRepository attendanceRecordRepository;

    @Mock
    EmployeeService employeeService;

    @Mock
    ShiftService shiftService;

    @InjectMocks
    AttendanceRecordService attendanceRecordService;

    @Test
    void shouldFetchAllUsers() {
        final List<AttendanceRecordEntity> expected = List.of(
                AttendanceRecordEntity.builder()
                        .id(1L)
                        .enteredAt(OffsetDateTime.of(2021, 10, 10, 10, 10, 10, 10, ZoneOffset.UTC))
                        .leftAt(OffsetDateTime.of(2021, 10, 10, 10, 10, 10, 10, ZoneOffset.UTC))
                        .elapsedTimePerShiftInMinutes(0L)
                        .build()
        );
        given(attendanceRecordRepository.findAll()).willReturn(expected);

        List<AttendanceRecordEntity> actual = attendanceRecordService.fetchAllAttendanceRecords();

        assertThat(actual).containsAll(expected);
        verify(attendanceRecordRepository, times(1)).findAll();
    }

    @Test
    void shouldFetchByEmployeeId() {
        final List<AttendanceRecordEntity> expected = List.of(
                AttendanceRecordEntity.builder()
                        .id(1L)
                        .enteredAt(OffsetDateTime.of(2021, 10, 10, 10, 10, 10, 10, ZoneOffset.UTC))
                        .leftAt(OffsetDateTime.of(2021, 10, 10, 10, 10, 10, 10, ZoneOffset.UTC))
                        .elapsedTimePerShiftInMinutes(0L)
                        .build()
        );
        given(attendanceRecordRepository.findByEmployeeEntityId(anyLong())).willReturn(expected);

        List<AttendanceRecordEntity> actual = attendanceRecordService.fetchAllAttendanceRecordsByEmployeeId(1L);

        assertThat(actual).containsAll(expected);
        verify(attendanceRecordRepository, times(1)).findByEmployeeEntityId(anyLong());
    }

    @Test
    void shouldUpdateEntryTime() {
        final OffsetDateTime updated = OffsetDateTime.of(2021, 10, 10, 15, 10, 10, 10, ZoneOffset.UTC);
        final AttendanceRecordEntity expected =
                AttendanceRecordEntity.builder()
                        .id(1L)
                        .enteredAt(OffsetDateTime.of(2021, 10, 10, 10, 10, 10, 10, ZoneOffset.UTC))
                        .leftAt(updated)
                        .elapsedTimePerShiftInMinutes(0L)
                        .build();
        given(attendanceRecordRepository.saveAndFlush(any(AttendanceRecordEntity.class))).willReturn(expected);
        given(employeeService.employeeExistsById(anyLong())).willReturn(true);
        given(attendanceRecordRepository.findById(anyLong())).willReturn(Optional.of(expected));

        AttendanceRecordEntity actual = attendanceRecordService.updateExitTime(1L, 1L, updated);

        assertThat(actual).usingRecursiveComparison()
                .isEqualTo(expected);
        verify(attendanceRecordRepository, times(1)).saveAndFlush(any(AttendanceRecordEntity.class));
    }
}
