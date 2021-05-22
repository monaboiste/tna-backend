package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zgora.uz.wiea.tna.model.Employee;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.service.EmployeeService;
import pl.zgora.uz.wiea.tna.util.EmployeeUtils;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    Employee createEmployee(@RequestBody final Employee employee) {
        final EmployeeEntity employeeEntity = employeeService.createEmployee(
                EmployeeUtils.mapEmployeeToEntity(employee));
        return EmployeeUtils.mapEmployeeEntityToEmployee(employeeEntity);
    }
}
