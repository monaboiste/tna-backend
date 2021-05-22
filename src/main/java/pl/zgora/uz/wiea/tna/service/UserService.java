package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.Role;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.UserRepository;
import pl.zgora.uz.wiea.tna.service.exception.UserConstraintViolationException;
import pl.zgora.uz.wiea.tna.service.exception.UserNotFoundException;
import pl.zgora.uz.wiea.tna.util.UserUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserEntity> fetchAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity fetchUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Transactional
    public UserEntity createUser(final UserEntity userEntity) {
        if (userRepository.existsByUsername(userEntity.getUsername())) {
            throw new UserConstraintViolationException();
        }

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRole(Role.USER);

        return userRepository.saveAndFlush(userEntity);
    }


    @Transactional
    public void deleteUser(long id) {
        final UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        userRepository.delete(userEntity);
    }
}
