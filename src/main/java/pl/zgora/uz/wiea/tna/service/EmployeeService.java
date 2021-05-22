package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zgora.uz.wiea.tna.model.Employee;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.EmployeeRepository;
import pl.zgora.uz.wiea.tna.service.exception.EmployeeNotFoundException;
import pl.zgora.uz.wiea.tna.service.exception.UserNotFoundException;
import pl.zgora.uz.wiea.tna.util.EmployeeUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> fetchAllEmployees() {
        final List<EmployeeEntity> employeeEntities = employeeRepository
                .findAll();
        return employeeEntities.stream()
                .map(EmployeeUtils::mapEmployeeEntityToEmployee)
                .collect(Collectors.toList());
    }

    @Transactional
    public Employee createEmployee(final Employee employee) {
        EmployeeEntity employeeEntity = EmployeeUtils
                .mapEmployeeToEmployeeEntity(employee);

        EmployeeEntity saved = employeeRepository.saveAndFlush(employeeEntity);
        return EmployeeUtils.mapEmployeeEntityToEmployee(saved);
    }
}
