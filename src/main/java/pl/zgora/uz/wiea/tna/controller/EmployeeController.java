package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.zgora.uz.wiea.tna.model.Employee;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.service.EmployeeService;
import pl.zgora.uz.wiea.tna.util.EmployeeUtils;
import pl.zgora.uz.wiea.tna.util.UserUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    List<Employee> fetchAllEmployees() {
        final List<EmployeeEntity> employeeEntities = employeeService.fetchAllEmployees();
        final List<Employee> employees = employeeEntities.stream()
                .map(EmployeeUtils::mapEmployeeEntityToEmployee)
                .collect(Collectors.toList());
        return employees;
    }

    @GetMapping("/{id}")
    Employee fetchEmployeeById(@PathVariable("id") long id) {
        final EmployeeEntity userEntity = employeeService.fetchEmployeeById(id);
        return EmployeeUtils.mapEmployeeEntityToEmployee(userEntity);
    }


    @PostMapping
    Employee createEmployee(@RequestBody final Employee employee) {
        final EmployeeEntity employeeEntity = employeeService.createEmployee(
                EmployeeUtils.mapEmployeeToEntity(employee));
        return EmployeeUtils.mapEmployeeEntityToEmployee(employeeEntity);
    }
}
