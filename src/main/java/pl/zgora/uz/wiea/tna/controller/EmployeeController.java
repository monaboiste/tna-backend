package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.zgora.uz.wiea.tna.model.Employee;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.service.EmployeeService;
import pl.zgora.uz.wiea.tna.util.EmployeeUtils;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    List<Employee> fetchAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

    @PostMapping
    Employee createEmployee(@RequestBody final Employee employee)
    {
        final EmployeeEntity employeeEntity = employeeService
                .createEmployee(EmployeeUtils.mapEmployeeToEmployeeEntity(employee));
        return EmployeeUtils.mapEmployeeEntityToEmployee(employeeEntity);
    }
}
