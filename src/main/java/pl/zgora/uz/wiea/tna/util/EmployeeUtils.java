package pl.zgora.uz.wiea.tna.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zgora.uz.wiea.tna.model.Employee;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeUtils {

    static public Employee mapEmployeeEntityToEmployee(final EmployeeEntity employeeEntity) {
        return Employee.builder()
                .id(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .department(employeeEntity.getDepartment())
                .street(employeeEntity.getStreet())
                .postCode(employeeEntity.getPostCode())
                .city(employeeEntity.getCity())
                .contractId(employeeEntity.getContractId())
                .build();
    }

    static public EmployeeEntity mapEmployeeToEntity(final Employee employee) {
        return EmployeeEntity.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .department(employee.getDepartment())
                .street(employee.getStreet())
                .postCode(employee.getPostCode())
                .city(employee.getCity())
                .contractId(employee.getContractId())
                .build();
    }
}
