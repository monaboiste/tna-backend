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

    public List<User> fetchAllUsers() {
        final List<UserEntity> userEntities = userRepository.findAll();
        final List<User> users = userEntities.stream()
                .map(UserUtils::mapUserEntityToUser)
                .collect(Collectors.toList());
        return users;
    }

    public User fetchUserById(long id) {
        final UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        final User user = UserUtils.mapUserEntityToUser(userEntity);
        return user;
    }

    @Transactional
    public User createUser(final User user) {
        UserEntity userEntity = UserUtils.mapUserToUserEntity(user);

        if (userRepository.existsByUsername(userEntity.getUsername())) {
            throw new UserConstraintViolationException();
        }

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRole(Role.USER);

        UserEntity saved = userRepository.saveAndFlush(userEntity);
        return UserUtils.mapUserEntityToUser(saved);
    }


    public void deleteUser(long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        userRepository.delete(userEntity);
    }
}
