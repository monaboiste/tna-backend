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
        final UserEntity userEntity = new UserEntity(1, "testname", "test");
        final User user = UserUtils.mapUserEntityToUser(userEntity);

        assertAll(
                () -> assertEquals(userEntity.getId(), user.getId()),
                () -> assertEquals(userEntity.getUsername(), user.getUsername()),
                () -> assertEquals(userEntity.getPassword(), user.getPassword())
        );
    }

    @Test
    void shouldMapUserToUserEntity() {
        final User user = new User(1, "testname", "test");
        final UserEntity userEntity = UserUtils.mapUserToUserEntity(user);

        assertAll(
                () -> assertEquals(user.getId(), userEntity.getId()),
                () -> assertEquals(user.getUsername(), userEntity.getUsername()),
                () -> assertEquals(user.getPassword(), userEntity.getPassword())
        );
    }
}
