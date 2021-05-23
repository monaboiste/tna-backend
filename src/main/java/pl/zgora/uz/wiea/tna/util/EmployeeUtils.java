package pl.zgora.uz.wiea.tna.util;


import pl.zgora.uz.wiea.tna.model.Employee;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;

public class EmployeeUtils {

    static public Employee mapEmployeeEntityToEmployee(final EmployeeEntity employeeEntity){
        return Employee.builder()
                .id(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .street(employeeEntity.getStreet())
                .postCode(employeeEntity.getPostCode())
                .city(employeeEntity.getCity())
                .contractId(employeeEntity.getContractId())
                .build();
    }

    static public EmployeeEntity mapEmployeeToEmployeeEntity(final Employee employee){
        return EmployeeEntity.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .street(employee.getStreet())
                .postCode(employee.getPostCode())
                .city(employee.getCity())
                .contractId(employee.getContractId())
                .build();
    }
}
