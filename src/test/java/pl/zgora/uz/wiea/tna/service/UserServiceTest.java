package pl.zgora.uz.wiea.tna.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldFetchAllUsers() {
        final List<UserEntity> userEntities = Arrays.asList(new UserEntity(1L, "test1", "test1"));
        given(userRepository.findAll()).willReturn(userEntities);

        List<User> users = userService.fetchAllUsers();

        assertAll(
                () -> assertEquals(userEntities.size(), users.size()),
                () -> assertEquals(userEntities.get(0).getId(), users.get(0).getId()),
                () -> assertEquals(userEntities.get(0).getUsername(), users.get(0).getUsername()),
                () -> assertEquals(userEntities.get(0).getPassword(), users.get(0).getPassword())
        );
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldFetchUserById() {
        final long id = 1L;
        final UserEntity userEntity = new UserEntity(id, "test1", "test1");
        given(userRepository.findById(id)).willReturn(Optional.of(userEntity));

        final User user = userService.fetchUserById(id);

        assertAll(
                () -> assertEquals(userEntity.getId(), user.getId()),
                () -> assertEquals(userEntity.getUsername(), user.getUsername()),
                () -> assertEquals(userEntity.getPassword(), user.getPassword())
        );
        verify(userRepository, times(1)).findById(id);
    }
}