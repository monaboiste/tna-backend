package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.UserRepository;
import pl.zgora.uz.wiea.tna.service.exception.UserNotFoundException;
import pl.zgora.uz.wiea.tna.util.UserUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> fetchAllUser() {
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
}
