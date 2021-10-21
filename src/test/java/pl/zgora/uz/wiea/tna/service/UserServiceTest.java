package pl.zgora.uz.wiea.tna.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import pl.zgora.uz.wiea.tna.persistence.entity.Role;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void shouldFetchAllUsers() {
        final List<UserEntity> expected = List.of(
                UserEntity.builder()
                        .id(1L)
                        .username("sample")
                        .password("sample")
                        .role(Role.USER)
                        .build()
        );
        given(userRepository.findAll()).willReturn(expected);

        List<UserEntity> actual = userService.fetchAllUsers();

        assertThat(actual).containsAll(expected);
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

        assertThat(actual).usingRecursiveComparison()
                .isEqualTo(expected);
        verify(userRepository, times(1)).findById(id);
    }
}