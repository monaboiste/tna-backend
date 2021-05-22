package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.Role;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.EmployeeRepository;
import pl.zgora.uz.wiea.tna.persistence.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeEntity createEmployee(final EmployeeEntity employeeEntity) {
        final String username = generateUsername(employeeEntity);
        final String password = generateDefaultPassword();

        final UserEntity userEntity = UserEntity.builder()
                .username(username)
                .password(password)
                .role(Role.USER)
                .build();
        employeeEntity.setUserEntity(userEntity);

        return employeeRepository.saveAndFlush(employeeEntity);
    }

    private String generateUsername(final EmployeeEntity employeeEntity) {
        final String lastname = employeeEntity.getLastname().toLowerCase();
        final char firstLetterOfName = employeeEntity.getFirstname().toLowerCase().charAt(0);
        final String lastThreeContractNumbers = employeeEntity.getContractId()
                .substring(employeeEntity.getContractId().length() - 3);

        final String username = firstLetterOfName + lastname + lastThreeContractNumbers;
        return username;
    }

    private String generateDefaultPassword() {
        return "test";
    }
}
