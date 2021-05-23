package pl.zgora.uz.wiea.tna.util;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
public class UserUtilsTest {

    @Test
    void shouldMapUserEntityToUser() {
        final UserEntity expected = UserEntity.builder()
                .id(1L)
                .username("sample")
                .password("sample")
                .build();

        final User actual = UserUtils.mapUserEntityToUser(expected);

        assertAll(
                () -> assertEquals(expected.getId(), actual.getId()),
                () -> assertEquals(expected.getUsername(), actual.getUsername()),
                () -> assertEquals(expected.getPassword(), actual.getPassword())
        );
    }

    @Test
    void shouldMapUserToUserEntity() {
        final User expected = User.builder()
                .id(1L)
                .username("sample")
                .password("sample")
                .build();

        final UserEntity actual = UserUtils.mapUserToUserEntity(expected);

        assertAll(
                () -> assertEquals(expected.getId(), actual.getId()),
                () -> assertEquals(expected.getUsername(), actual.getUsername()),
                () -> assertEquals(expected.getPassword(), actual.getPassword())
        );
    }
}
