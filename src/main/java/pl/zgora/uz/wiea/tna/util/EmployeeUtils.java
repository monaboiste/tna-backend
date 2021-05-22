package pl.zgora.uz.wiea.tna.util;


import pl.zgora.uz.wiea.tna.model.Employee;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.UserRepository;

public class EmployeeUtils {

    static public Employee mapEmployeeEntityToEmployee(final EmployeeEntity employeeEntity){
        return Employee.builder()
                .id(employeeEntity.getId())
                .user(UserUtils.mapUserEntityToUser(employeeEntity.getUser()))
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .dateOfBirth(employeeEntity.getDateOfBirth())
                .street(employeeEntity.getStreet())
                .postCode(employeeEntity.getPostCode())
                .city(employeeEntity.getCity())
                .build();
    }

    static public EmployeeEntity mapEmployeeToEmployeeEntity(final Employee employee){
        return EmployeeEntity.builder()
                .id(employee.getId())
                .user(UserUtils.mapUserToUserEntity(employee.getUser()))
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .dateOfBirth(employee.getDateOfBirth())
                .street(employee.getStreet())
                .postCode(employee.getPostCode())
                .city(employee.getCity())
                .build();
    }
}
