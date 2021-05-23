package pl.zgora.uz.wiea.tna.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zgora.uz.wiea.tna.model.Employee;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeUtils {

    static public Employee mapEmployeeEntityToEmployee(final EmployeeEntity employeeEntity) {
        return Employee.builder()
                .id(employeeEntity.getUserId())
                .firstname(employeeEntity.getFirstname())
                .lastname(employeeEntity.getLastname())
                .department(employeeEntity.getDepartment())
                .contractId(employeeEntity.getContractId())
                .build();
    }

    static public EmployeeEntity mapEmployeeToEntity(final Employee employee) {
        return EmployeeEntity.builder()
                .userId(employee.getId())
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .department(employee.getDepartment())
                .contractId(employee.getContractId())
                .build();
    }
}
