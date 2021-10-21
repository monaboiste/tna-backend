package pl.zgora.uz.wiea.tna.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.Role;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    UserService userService;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    void shouldFetchAllEmployees() {
        final List<EmployeeEntity> expected = List.of(
                EmployeeEntity.builder()
                        .id(1L)
                        .firstName("Bob")
                        .lastName("The Builder")
                        .department("IT")
                        .contractId("CV123456")
                        .city("New York")
                        .postCode("12-1234")
                        .street("Wall Street 12/2")
                        .build()
        );
        given(employeeRepository.findAll()).willReturn(expected);

        List<EmployeeEntity> actual = employeeService.fetchAllEmployees();

        assertThat(actual).containsAll(expected);
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void shouldEmployeeUserById() {
        final long id = 1L;
        final EmployeeEntity expected = EmployeeEntity.builder()
                .id(id)
                .firstName("Bob")
                .lastName("The Builder")
                .department("IT")
                .contractId("CV123456")
                .city("New York")
                .postCode("12-1234")
                .street("Wall Street 12/2")
                .build();
        given(employeeRepository.findById(id)).willReturn(Optional.of(expected));

        final EmployeeEntity actual = employeeService.fetchEmployeeById(id);

        assertThat(actual).usingRecursiveComparison()
                .isEqualTo(expected);
        verify(employeeRepository, times(1)).findById(id);
    }

    @Test
    void shouldCreateNewEmployee() {
        final long id = 1L;
        final EmployeeEntity expected = EmployeeEntity.builder()
                .id(id)
                .firstName("Bob")
                .lastName("The Builder")
                .department("IT")
                .contractId("CV123456")
                .city("New York")
                .postCode("12-1234")
                .street("Wall Street 12/2")
                .build();
        given(employeeRepository.saveAndFlush(any(EmployeeEntity.class))).willReturn(expected);
        given(userService.createUser(any(UserEntity.class))).willReturn(new UserEntity(id, "bthe456", "test", Role.USER));

        final EmployeeEntity actual = employeeService.createEmployee(expected);

        assertThat(actual).usingRecursiveComparison()
                .isEqualTo(expected);
        verify(employeeRepository, times(1)).saveAndFlush(expected);
    }
}
