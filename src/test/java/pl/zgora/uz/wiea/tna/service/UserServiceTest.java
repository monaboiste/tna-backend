package pl.zgora.uz.wiea.tna.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.Role;
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
        final List<UserEntity> expected = Arrays.asList(
                UserEntity.builder()
                        .id(1L)
                        .username("sample")
                        .password("sample")
                        .role(Role.USER)
                        .build()
        );
        given(userRepository.findAll()).willReturn(expected);

        List<UserEntity> actual = userService.fetchAllUsers();

        assertAll(
                () -> assertEquals(expected.size(), actual.size()),
                () -> assertEquals(expected.get(0).getId(), actual.get(0).getId()),
                () -> assertEquals(expected.get(0).getUsername(), actual.get(0).getUsername()),
                () -> assertEquals(expected.get(0).getPassword(), actual.get(0).getPassword())
        );
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldFetchUserById() {
        final long id = 1L;
        final UserEntity expected = UserEntity.builder()
                .id(id)
                .username("sample")
                .password("sample")
                .role(Role.USER)
                .build();
        given(userRepository.findById(id)).willReturn(Optional.of(expected));

        final UserEntity actual = userService.fetchUserById(id);

        assertAll(
                () -> assertEquals(expected.getId(), actual.getId()),
                () -> assertEquals(expected.getUsername(), actual.getUsername()),
                () -> assertEquals(expected.getPassword(), actual.getPassword())
        );
        verify(userRepository, times(1)).findById(id);
    }
}