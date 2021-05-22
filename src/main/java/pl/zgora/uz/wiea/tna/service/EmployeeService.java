package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.EmployeeRepository;
import pl.zgora.uz.wiea.tna.service.exception.UserNotFoundException;
import pl.zgora.uz.wiea.tna.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserService userService;

    public List<EmployeeEntity> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity fetchEmployeeById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
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
        employeeEntity.setUserEntity(savedUserEntity);


        return employeeRepository.saveAndFlush(employeeEntity);
    }

    private String generateDefaultUsername(final EmployeeEntity employeeEntity) {
        final char firstLetterOfName = employeeEntity.getFirstname().toLowerCase().charAt(0);
        final String lastname = employeeEntity.getLastname().split(" ")[0].toLowerCase();
        final String lastThreeContractNumbers = employeeEntity.getContractId()
                .substring(employeeEntity.getContractId().length() - 3);

        final String username = firstLetterOfName + lastname + lastThreeContractNumbers;
        return username;
    }

    private String generateDefaultPassword() {
        return "test";
    }

    private void reformatFields(final EmployeeEntity employeeEntity) {
        employeeEntity.setFirstname(StringUtils.toTitleCase(employeeEntity.getFirstname()));
        employeeEntity.setLastname(StringUtils.toTitleCase(employeeEntity.getLastname()));
        employeeEntity.setContractId(employeeEntity.getContractId().toUpperCase());
    }
}
