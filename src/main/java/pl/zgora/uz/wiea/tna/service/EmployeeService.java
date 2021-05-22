package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zgora.uz.wiea.tna.model.Employee;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.EmployeeRepository;
import pl.zgora.uz.wiea.tna.util.EmployeeUtils;
import pl.zgora.uz.wiea.tna.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final UserService userService;

    public List<Employee> fetchAllEmployees() {
        final List<EmployeeEntity> employeeEntities = employeeRepository
                .findAll();
        return employeeEntities.stream()
                .map(EmployeeUtils::mapEmployeeEntityToEmployee)
                .collect(Collectors.toList());
    }

    @Transactional
    public EmployeeEntity createEmployee(final EmployeeEntity employeeEntity) {
        reformatFields(employeeEntity);

        final String username = generateDefaultUsername(employeeEntity);
        final String password = generateDefaultPassword();

        final UserEntity userEntity = UserEntity.builder()
                .username(username)
                .password(password)
                .build();
        final UserEntity savedUserEntity = userService.createUser(userEntity);
        employeeEntity.setUser(savedUserEntity);


        return employeeRepository.saveAndFlush(employeeEntity);
    }

    private String generateDefaultUsername(final EmployeeEntity employeeEntity) {
        final char firstLetterOfName = employeeEntity.getFirstName().toLowerCase().charAt(0);
        final String lastname = employeeEntity.getLastName().split(" ")[0].toLowerCase();
        final String lastThreeContractNumbers = employeeEntity.getContractId()
                .substring(employeeEntity.getContractId().length() - 3);

        final String username = firstLetterOfName + lastname + lastThreeContractNumbers;
        return username;
    }

    private String generateDefaultPassword() {
        return "test";
    }

    private void reformatFields(final EmployeeEntity employeeEntity) {
        employeeEntity.setFirstName(StringUtils.toTitleCase(employeeEntity.getFirstName()));
        employeeEntity.setLastName(StringUtils.toTitleCase(employeeEntity.getLastName()));
        employeeEntity.setContractId(employeeEntity.getContractId().toUpperCase());
    }
}
