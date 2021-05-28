package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.EmployeeRepository;
import pl.zgora.uz.wiea.tna.service.exception.ContractIdViolationException;
import pl.zgora.uz.wiea.tna.service.exception.UserNotFoundException;
import pl.zgora.uz.wiea.tna.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserService userService;

    public List<EmployeeEntity> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity fetchEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(UserNotFoundException::new);
    }

    @Transactional
    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
        validateContractId(employeeEntity.getContractId());
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

    public boolean employeeExistsById(long employeeId) {
        return employeeRepository.existsById(employeeId);
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

    private void validateContractId(final String contractId) {
        if (Objects.isNull(contractId)
                || contractId.length() < 3
                || employeeRepository.existsByContractId(contractId)) {
            throw new ContractIdViolationException();
        }
    }
}
